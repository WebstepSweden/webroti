require(
    ['jquery', 'json', 'bootstrap'],

    function($) {
        //Function globals
        CONFIRMATION_DELAY = 1200; //ms

        //Get meeting id from url hash
        var meetingId = window.location.hash;
        $('.back-to-meeting').prop('href', $('.back-to-meeting').prop('href') + meetingId);


        //Print slider value as a number
        var setVoteValue = (function() {
            var voteValueElm = $('.vote-value');

            return function(){
                if (voteValueElm.length) {
                    voteValueElm.text($('input[type="range"]').get(0).value.substr(0,3));
                }
            }
        })();


        var sliderElm = $('input[type="range"]');
        if (sliderElm.length) {
            sliderElm.on('change', setVoteValue);
        }

        $('.vote-button').on('click', function (e) {
            e.preventDefault();

            //Do vote
            jQuery.ajax({
                url: "rest/vote",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify({
                    "meetingId": meetingId.substring(1),
                    "vote": $('.vote-value').text()
                }),
                success: function (data, textStatus, jqXHR) {
                    console.dir(data);
                    sliderElm.get(0).value = 3;
                    sliderElm.trigger('change');
                    setTimeout(function () {
                        $('.confirmation').modal('hide');
                    }, CONFIRMATION_DELAY);
                }});

            $('.confirmation').modal();
        });

        setVoteValue();

    }
);

(function ($) {
    var CONFIRMATION_DELAY = 3000; //ms

    $('.create-meeting').on('click', function (e) {
        e.preventDefault();
        $(this).addClass("disabled");
        $.ajax({
            url: "/rest/meeting/create",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                "operation": "createMeeting"
            }),
            success: function (data, textStatus, jqXHR) {
                //console.log("Post response:"); console.dir(data); console.log(textStatus); console.dir(jqXHR);
                if (data && data.id) {
                    window.location = 'meeting.html#' + data.id;
                }
            }});
    });

    var meetingId = window.location.hash;
    $('.meeting-id').html(meetingId);

    var voteUrl = 'http://' + window.location.host + '/vote.html' + meetingId;
    $('.vote-link').prop('href', voteUrl);
    $('.vote-url').html(voteUrl);
    $('.back-to-meeting').prop('href', $('.back-to-meeting').prop('href') + meetingId);

    var voteValueElm = $('.vote-value');
    if (voteValueElm.length) {
        voteValueElm.text($('input[type="range"]').get(0).value);
    }

    var sliderElm = $('input[type="range"]');
    if (sliderElm.length) {
        sliderElm.on('change', function (e) {
            $('.vote-value').text(('' + this.value).substr(0,3));
        });
    }

    $('.vote-button').on('click', function (e) {
        e.preventDefault();

        //Do vote
        jQuery.ajax({
            url: "/rest/vote",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                "meetingId": meetingId.substring(1),
                "vote": $('.vote-value').text()
            }),
            success: function (data, textStatus, jqXHR) {
                console.dir(data);
                setTimeout(function () {
                    $('.confirmation').modal('hide');
                }, CONFIRMATION_DELAY);
            }});

        $('.confirmation').modal();
        sliderElm.get(0).value = 3;
        sliderElm.trigger('change');
    });


    if(meetingId){
        jQuery.get("/rest/meeting?id=" + meetingId.substr(1), function (data, textStatus, jqXHR) {
            console.dir(data);
            if(data.votes){
                if($('.number-of-votes').length){
                    $('.number-of-votes').text(data.votes.length);
                }
                if(data.average){
                    $('.average-roti').text(data.average);
                }
            } else {
                $('.number-of-votes').text('0');
            }
        });
    }


})(jQuery);

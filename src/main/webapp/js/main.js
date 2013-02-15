(function($){
    var CONFIRMATION_DELAY = 3000; //ms

    $('.create-meeting').on('click', function(e){
        e.preventDefault();
        $(this).addClass("disabled");
        $.ajax({
            url:"/rest/meeting/create",
            type:"POST",
            contentType: "application/json",
            data: JSON.stringify({
                "operation": "createMeeting"
            }),
            success: function(data, textStatus, jqXHR) {
                //console.log("Post response:"); console.dir(data); console.log(textStatus); console.dir(jqXHR);
                if(data && data.id){
                    window.location = 'meeting.html#' + data.id;
                }
            }});
    });

    var meetingId = window.location.hash;
    $('.meeting-id').html(meetingId);

    var voteUrl = 'http://' + window.location.host + '/vote.html' + meetingId;
    $('.vote-link').prop('href', voteUrl);
    $('.vote-url').html(voteUrl);

    var voteValueElm = $('.vote-value');
    if(voteValueElm.length){
        voteValueElm.text($('input[type="range"]').get(0).value);
    }

    var sliderElm = $('input[type="range"]');
    if(sliderElm.length){
        sliderElm.on('change', function(e){
            $('.vote-value').text(this.value);
        });
    }

    $('.vote-button').on('click', function(e) {
        e.preventDefault();

        $('.confirmation').modal();
        sliderElm.get(0).value = 3;
        sliderElm.trigger('change');

        setTimeout(function(){
            $('.confirmation').modal('hide');
        }, CONFIRMATION_DELAY);

    });
})(jQuery);

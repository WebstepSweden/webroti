(function($){
    var CONFIRMATION_DELAY = 3000; //ms


    var meetingId = window.location.hash;
    $('.meeting-id').html(meetingId);

    var voteUrl = 'vote.html' + meetingId;
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

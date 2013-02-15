(function($){
    var CONFIRMATION_DELAY = 3000; //ms


    var meetingId = window.location.hash;
    $('.meeting-id').html(meetingId);

    var voteUrl = 'vote.html' + meetingId;
    $('.vote-link').prop('href', voteUrl);
    $('.vote-url').html(voteUrl);

    $('.vote-value').text($('input[type="range"]').get(0).value);

    $('input[type="range"]').on('change', function(e){
        $('.vote-value').text(this.value);
    });

    $('.vote-button').on('click', function(e) {
        e.preventDefault();

        $('.confirmation').modal();

        setTimeout(function(){
            $('.confirmation').modal('hide');
        }, CONFIRMATION_DELAY);

    });
})(jQuery);

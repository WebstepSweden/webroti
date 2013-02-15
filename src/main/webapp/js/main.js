(function($){
    var meetingId = window.location.hash;
    $('.meeting-id').html(meetingId);

    var voteUrl = 'vote.html' + meetingId;
    $('.vote-link').prop('href', voteUrl);
    $('.vote-url').html(voteUrl);
})(jQuery);

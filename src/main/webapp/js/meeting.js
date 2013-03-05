require(
    ['jquery', 'jqueryQR'],

    function ($) {
        //Get meeting id from url hash
        var meetingId = window.location.hash;


        function updateUIwithVoteResults(voteData){
            if (voteData.votes) {
                if ($('.number-of-votes').length) {
                    $('.number-of-votes').text(voteData.votes.length);
                }
                if (voteData.average) {
                    $('.average-roti').text(voteData.average);
                }
            } else {
                $('.number-of-votes').text('0');
            }
        }


        function updateUIwithMeetingId(meetingId) {
            $('.meeting-id').html(meetingId);

            var voteUrl = 'http://' + window.location.host + '/vote.html' + meetingId;
            $('.vote-link').prop('href', voteUrl);
            $('.vote-url').html(voteUrl);

            $('.qr-code').qrcode({
                text: $('.vote-url').text(),
                width: 100,
                height: 100
            });
        }


        //Request meeting data from server
        if (meetingId) {
            jQuery.get("rest/meeting", {id: meetingId.substr(1)})
                .done(function (data, textStatus, jqXHR) {
                    updateUIwithVoteResults(data);
                 })
                .fail(function(data, textStatus, jqXHR) {
                    alert("Fail!");
                    console.log(data);
                    console.dir(data);
                });
        }


        if(meetingId){
            updateUIwithMeetingId(meetingId);
        }

    }
);



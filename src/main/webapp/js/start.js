require(
    ['jquery', 'bootstrap', 'jqueryQR'],

    function($) {

        function createMeeting(successCallback) {
            $.ajax({
                url: "rest/meeting/create",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify({
                    "operation": "createMeeting"
                }),
                success: function (data, textStatus, jqXHR) {
                    //console.log("Post response:"); console.dir(data); console.log(textStatus); console.dir(jqXHR); //DEBUG
                    if (data && data.id) {
                        successCallback(data.id);
                    }
                }
            });
        };


        function forwardToMeetingPage(meetingId){
            window.location = 'meeting.html#' + meetingId;
        };

        $('.create-meeting').on('click', function (e) {
            e.preventDefault();
            $(this).addClass("disabled");
            createMeeting(forwardToMeetingPage);
        });

    }
);

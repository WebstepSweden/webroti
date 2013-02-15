package se.diversify.webroti.rest;

import com.google.gson.Gson;
import se.diversify.webroti.data.Meeting;
import se.diversify.webroti.data.Repository;
import se.diversify.webroti.data.Vote;
import se.diversify.webroti.rest.vo.MeetingVO;
import se.diversify.webroti.rest.vo.VoteVO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author dvalfrid
 * @version 1.0
 */
@Path("meeting")
public class MeetingResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMeeting(@QueryParam("id") String id) {
        Meeting meeting = Repository.getMeeting(id);

        MeetingVO.Builder builder = MeetingVO.getBuilder().id(meeting.getId());
        for(Vote vote : meeting.getVotes()) {
            builder.add(new VoteVO(vote.getValue()));
        }

        return new Gson().toJson(builder.build());
    }


}

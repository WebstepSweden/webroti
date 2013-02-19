package se.diversify.webroti.rest;

import com.google.gson.Gson;
import se.diversify.webroti.data.Meeting;
import se.diversify.webroti.data.Repository;
import se.diversify.webroti.data.Vote;
import se.diversify.webroti.rest.vo.MeetingVO;
import se.diversify.webroti.rest.vo.VoteVO;

import javax.ws.rs.*;
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
		String valueToReturn = "";
		try {
			Meeting meeting = Repository.getMeeting(id);
			if (meeting != null) {
				MeetingVO.Builder builder = MeetingVO.getBuilder().id(meeting.getId());
				for (Vote vote : meeting.getVotes()) {
					builder.add(new VoteVO(vote.getValue()));
				}
				valueToReturn = new Gson().toJson(builder.build());
			}
		} catch (IllegalArgumentException e) {
			valueToReturn = new Gson().toJson(e.getMessage());
		}
		return valueToReturn;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public String createMeeting() {
		Meeting meeting = Repository.createMeeting();
		return new Gson().toJson(MeetingVO.getBuilder()
                .id(meeting.getId())
				.build());
	}
}

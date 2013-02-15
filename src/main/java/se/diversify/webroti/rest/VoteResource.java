package se.diversify.webroti.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.diversify.webroti.data.Meeting;
import se.diversify.webroti.data.Vote;


@Path("vote")
public class VoteResource {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response vote(@FormParam("meetingId") String meetingId, @FormParam("vote") String value){
		// Find meeting from meetingId
		Meeting meet = new Meeting();
				
		// Add vote to this meeting
		Double voteValue = Double.valueOf(value);
		meet.getVotes().add(new Vote(voteValue));
		
		return Response.ok().build();
	}

}

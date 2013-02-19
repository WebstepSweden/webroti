package se.diversify.webroti.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import se.diversify.webroti.data.Meeting;
import se.diversify.webroti.data.Repository;
import se.diversify.webroti.data.Vote;
import se.diversify.webroti.rest.vo.AddVoteVO;


@Path("vote")
public class VoteResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response vote(String addVoteStr){
		Response toReturn = null;
		try {
			AddVoteVO vo = new Gson().fromJson(addVoteStr, AddVoteVO.class);
			Meeting meet = Repository.getMeeting(vo.getMeetingId());
			// Add vote to this meeting
			meet.addVote(new Vote(vo.getVote()));
			toReturn = Response.ok().build();
		}
		catch( Exception e ){
			// Kan kastas fran Repository
            toReturn = Response.ok(e.getMessage()).build();
		}
		return toReturn;
	}
}

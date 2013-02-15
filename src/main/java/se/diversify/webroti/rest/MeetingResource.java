package se.diversify.webroti.rest;

import com.google.gson.Gson;
import se.diversify.webroti.rest.vo.Meeting;
import se.diversify.webroti.rest.vo.Vote;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author dvalfrid
 * @version 1.0
 */
@Path("meeting")
public class MeetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMeeting() {
       return new Gson().toJson(Meeting.getBuilder().id("10").add(new Vote(10.0)).build());
    }
}

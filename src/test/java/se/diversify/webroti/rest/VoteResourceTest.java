package se.diversify.webroti.rest;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import se.diversify.webroti.data.Meeting;
import se.diversify.webroti.data.Repository;
import se.diversify.webroti.rest.vo.AddVoteVO;

public class VoteResourceTest {

    private Meeting meeting;

	@Before
    public void before() {
        meeting = Repository.createMeeting();
    }

	@Test
	public void testOk() {
		AddVoteVO vo = new AddVoteVO(4.5, meeting.getId());
		Response response = new VoteResource().vote(toJson(vo));
		assertEquals(200, response.getStatus());
		assertNull(response.getEntity());
		Meeting meet = Repository.getMeeting(meeting.getId());
		assertNotNull(meet);
		assertEquals(1, meet.getVotes().size());
		assertEquals(4.5d, meet.getVotes().get(0).getValue(), 0.0);
	}


	@Test
	public void testWrongMeetingId() {
		AddVoteVO vo = new AddVoteVO(4.5, "apa");
		Response response = new VoteResource().vote(toJson(vo));
		assertEquals(200, response.getStatus());
		assertEquals("Meeting with id apa can not be found", response.getEntity());
	}

	private String toJson(AddVoteVO vo){
		return new Gson().toJson(vo);
	}
}

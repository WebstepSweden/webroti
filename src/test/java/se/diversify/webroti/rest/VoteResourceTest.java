package se.diversify.webroti.rest;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import se.diversify.webroti.data.Meeting;
import se.diversify.webroti.data.Repository;

public class VoteResourceTest {

    private Meeting meeting;

	@Before
    public void before() {
        meeting = Repository.createMeeting();
    }

	@Test
	public void testOk() {
		Response response = new VoteResource().vote(meeting.getId(), "4.5");
		assertEquals(200, response.getStatus());
		assertNull(response.getEntity());
	}


	@Test
	public void testWrongMeetingId() {
		Response response = new VoteResource().vote("apa", "4.5");
		assertEquals(200, response.getStatus());
		assertEquals("Meeting with id apa can not be found", response.getEntity());
	}

}

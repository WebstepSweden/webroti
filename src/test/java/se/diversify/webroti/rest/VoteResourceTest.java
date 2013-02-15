package se.diversify.webroti.rest;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

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
		Response response = new VoteResource().vote(vo);
		assertEquals(200, response.getStatus());
		assertNull(response.getEntity());
	}


	@Test
	public void testWrongMeetingId() {
		AddVoteVO vo = new AddVoteVO(4.5, "apa");
		Response response = new VoteResource().vote(vo);
		assertEquals(200, response.getStatus());
		assertEquals("Meeting with id apa can not be found", response.getEntity());
	}

}

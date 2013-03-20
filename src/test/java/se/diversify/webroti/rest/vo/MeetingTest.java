package se.diversify.webroti.rest.vo;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class MeetingTest {

    private MeetingVO meeting;

    @Before
    public void beforeEachTest() throws Exception {
        meeting = MeetingVO.getBuilder().id("10").add(new VoteVO(1.0)).add(new VoteVO(3.0)).build();
    }

    @Test
    public void testGetAverage() throws Exception {
        Assert.assertEquals("2.0", meeting.getAverage());
    }

    @Test
    public void testGetMin() throws Exception {
        Assert.assertEquals("1.0", meeting.getMin());
    }

    @Test
    public void testGetMax() throws Exception {
        Assert.assertEquals("3.0", meeting.getMax());
    }
}

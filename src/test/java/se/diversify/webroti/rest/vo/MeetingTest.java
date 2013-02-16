package se.diversify.webroti.rest.vo;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class MeetingTest {
    @Test
    public void testGetAverage() throws Exception {
        MeetingVO meeting = MeetingVO.getBuilder().id("10").add(new VoteVO(1.0)).add(new VoteVO(3.0)).build();
        Assert.assertEquals("2.0", meeting.getAverage());
    }
}

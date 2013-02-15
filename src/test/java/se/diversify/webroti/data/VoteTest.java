package se.diversify.webroti.data;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class VoteTest {

    private Vote testedObject;

    @Before
    public void before() {
        testedObject = new Vote(5);
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(5.0, testedObject.getValue());
    }
}

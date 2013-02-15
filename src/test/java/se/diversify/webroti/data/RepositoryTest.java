package se.diversify.webroti.data;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;


public class RepositoryTest {

    private Meeting testedObject;

    @Before
    public void before() {
        testedObject = Repository.createMeeting();
    }

    @Test
    public void testCreateMeeting() throws Exception {
        assertNotNull(testedObject);
    }

    public void testGetMeeting() throws Exception {
        assertNotNull(Repository.getMeeting(testedObject.getId()));
    }
}

package se.diversify.webroti;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniel Valfridsson (daniel@valfridsson.net)
 * @version 1.0
 */
public class HelloWorldTest {

    private HelloWorld testedObject;


    @Before
    public void before() {
        testedObject = new HelloWorld("webroti");
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("webroti", testedObject.getName());
    }
}

package se.diversify.webroti.rest;


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
        testedObject = new HelloWorld();
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Hello World 2", testedObject.getName());
    }
}

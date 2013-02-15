package se.diversify.webroti;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import se.diversify.webroti.rest.HelloWorld;

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
        Assert.assertEquals("Hello World", testedObject.getName());
    }
}

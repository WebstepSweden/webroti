package se.diversify.webroti;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Just a Hello World to see if the REST service works
 *
 * A comment
 *
 * @author Daniel Valfridsson (daniel@valfridsson.net)
 * @version 1.0
 */
public class HelloWorld extends ServerResource {
    
    private final String name = "Hello World";
    
    public HelloWorld() {
    }

    @Get("json")
    public String getName() {
        return name;
    }
}

package se.diversify.webroti.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Just a Hello World to see if the REST service works
 *
 * A comment
 *
 * @author Daniel Valfridsson (daniel@valfridsson.net)
 * @version 1.0
 */
@Path("/helloworld")
public class HelloWorld {
    
    private final String name = "Hello World 2";
    
    public HelloWorld() {
    }

    @GET
    @Produces("text/plain")
    public String getName() {
        return name;
    }
}

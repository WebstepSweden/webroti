package se.diversify.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Christer Sandberg, Diversify Stockholm.
 */
@Path("time")
public class TimeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTime() {
        return String.valueOf(System.currentTimeMillis());
    }

}

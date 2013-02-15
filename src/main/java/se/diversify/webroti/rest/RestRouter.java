package se.diversify.webroti.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import se.diversify.webroti.HelloWorld;

/**
 * This class mapps the namespace to the right implementation
 *
 * @author dvalfrid
 * @version 1.0
 */
public class RestRouter extends Application{


    // someone was here.....
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/test", HelloWorld.class);
        return router;
    }
}

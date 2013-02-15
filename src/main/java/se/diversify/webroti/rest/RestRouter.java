package se.diversify.webroti.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class RestRouter  extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(HelloWorld.class);
        classes.add(MeetingReserouce.class);

        return classes;
    }
}

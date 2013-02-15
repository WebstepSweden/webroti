package se.diversify.sample;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author Christer Sandberg, Diversify Stockholm.
 */
public class SampleApplication extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(TimeResource.class);

        return classes;
    }

}

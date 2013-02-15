package se.diversify.webroti.time;

public class SystemTime {

    private static TimeFactory timeFactory = new SystemTimeFactory();

    public static long now() {
        return timeFactory.now();
    }

    protected static void setTimeFactory(TimeFactory newTimeFactory) {
        timeFactory = newTimeFactory;
    }

    protected static void resetTimeFactory() {
        timeFactory = new SystemTimeFactory();
    }

    protected interface TimeFactory {
        long now();
    }

    private static class SystemTimeFactory implements TimeFactory {
        public long now() {
            return System.currentTimeMillis();
        }
    }
}

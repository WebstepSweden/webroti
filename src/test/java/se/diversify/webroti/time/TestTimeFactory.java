package se.diversify.webroti.time;

public class TestTimeFactory implements SystemTime.TimeFactory {
    private final long now;

    public TestTimeFactory(long now) {
        this.now = now;
    }

    @Override
    public long now() {
        return now;
    }
}

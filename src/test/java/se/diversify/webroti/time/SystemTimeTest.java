package se.diversify.webroti.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SystemTimeTest {
    @Test
    public void shouldReturnCurrentTime() throws Exception {
        // Fixture

        // Test
        long before = System.currentTimeMillis();
        long actual = SystemTime.now();
        long after = System.currentTimeMillis();

        // Assert
        assertTrue(before <= actual);
        assertTrue(actual <= after);
    }

    @Test
    public void shouldUseTimeFromTestFactory() throws Exception {
        try {
        // Fixture
        final long now = 1234;
        final TestTimeFactory testTimeFactory = new TestTimeFactory(now);
        SystemTime.setTimeFactory(testTimeFactory);

        // Test
        final long actual = SystemTime.now();

        // Assert
        assertEquals(now, actual);
        } finally {
            SystemTime.resetTimeFactory();
        }
    }
}

package nl.cge.junit5examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTest {

    @Test
    public void testForMac() {
        String osName = System.getProperties().getProperty("os.name");
        assumeTrue("Mac OS X".equals(osName));

        assertTrue(true);
    }

    @Test
    public void testForWindows() {
        String osName = System.getProperties().getProperty("os.name");
        assumeTrue("Windows".equals(osName));

        assertTrue(false);
    }
}

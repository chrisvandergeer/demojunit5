package nl.cge.demo.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5DemoTest {

    @Test
    public void testMe() {
        assertTrue(true);
        assertEquals("een", "een");
    }
}

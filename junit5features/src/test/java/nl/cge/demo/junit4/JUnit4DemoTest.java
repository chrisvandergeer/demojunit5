package nl.cge.demo.junit4;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class JUnit4DemoTest {

    @Test
    public void testMe() {
        assertTrue(true);
        assertEquals("een", "een");
        assertThat(Long.valueOf(4), is(Long.valueOf(4)));
    }
}

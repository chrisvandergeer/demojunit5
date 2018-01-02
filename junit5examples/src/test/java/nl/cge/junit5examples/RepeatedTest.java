package nl.cge.junit5examples;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTest {

    @org.junit.jupiter.api.RepeatedTest(value = 10)
    public void testMe() {
        int randomNumber = new Random().nextInt(100);
        assertTrue(
                randomNumber <= 100,
                () -> "random getal " + randomNumber + " is groter dan 100" );
    }
}

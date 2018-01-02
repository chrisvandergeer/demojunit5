package nl.cge.junit5examples;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LambdaAssertions {

    class Persoon {
        String voornaam;
        String achternaam;
        String tussenvoegsels;

        public Persoon(String voornaam, String tussenvoegsels, String achternaam) {
            this.voornaam = voornaam;
            this.tussenvoegsels = tussenvoegsels;
            this.achternaam = achternaam;
        }
        public String getVoornaam() {
            return voornaam;
        }
        public String getAchternaam() {
            return achternaam;
        }
        public String getTussenvoegsels() {
            return tussenvoegsels;
        }
        public String toString() {
            return voornaam + " " + tussenvoegsels + " " + achternaam;
        }

    }

    @Test
    void showHowAssertAllWorks() {
        Persoon persoon = new Persoon("Peter", "van der", "Laan");
        assertAll("persoon",
                () -> assertEquals("Peter", persoon.getVoornaam()),
                () -> assertEquals("van der", persoon.getTussenvoegsels()),
                () -> assertEquals("Laan", persoon.getAchternaam()),
                () -> assertEquals("Peter van der Laan", persoon.toString())
        );
    }

    @Test
    void showHowAssertThrowsWorks() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> BigDecimal.TEN.divide(BigDecimal.ZERO));
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void showHowAssertTimeoutWorks() {
        assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(10000));
    }

    @Test
    void showHowTAssertimeoutPreemptivelyWorks() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> Thread.sleep(10000));
    }

}

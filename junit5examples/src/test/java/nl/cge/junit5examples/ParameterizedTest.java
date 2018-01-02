package nl.cge.junit5examples;

import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTest {


    @org.junit.jupiter.params.ParameterizedTest()
    @ValueSource(strings = { "aap", "noot", "mies" })
    void testMe(String waarde) {
        assertTrue(waarde.length() > 3);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testMe2(TimeUnit timeUnit) {
        assertTrue(timeUnit.name() != null);
    }


    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("periodeProvider")
    void testMe3(Periode periode) {
        assertTrue(periode.isEinddatumBeforeBegindatum());
    }

    static Stream<Periode> periodeProvider() {
        return Arrays.asList(
                new Periode(LocalDate.now(), LocalDate.now().plusMonths(3)),
                new Periode(LocalDate.now().minusDays(23), LocalDate.now().minusDays(22)))
                .stream();
    }

    static class Periode {
        LocalDate begindatum;
        LocalDate einddatum;

        public Periode(LocalDate begindatum, LocalDate einddatum) {
            this.begindatum = begindatum;
            this.einddatum = einddatum;
        }

        boolean isEinddatumBeforeBegindatum() {
            return begindatum.isBefore(einddatum);
        }
    }


}

package nl.cge.demo.exception;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class assertException {

    @org.junit.Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        try {
            BigDecimal.valueOf(99).divide(BigDecimal.ZERO);
        } catch (ArithmeticException e) {
            org.junit.Assert.assertEquals("Division by zero", e.getMessage());
            throw e;
        }
    }


    @Test
    public void testDivideByZeroWithJUnit5() {
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class,
                () -> BigDecimal.valueOf(99).divide(BigDecimal.ZERO));
        assertEquals("", arithmeticException.getMessage());
    }
}

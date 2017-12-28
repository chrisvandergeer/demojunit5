import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBigDecimal {

    private BigDecimal zero;
    private BigDecimal two;
    private BigDecimal ten;
    private BigDecimal five;

    @Before
    public void setup() {
        zero = new BigDecimal("0");
        two = new BigDecimal("2");
        five = new BigDecimal("5");
        ten = new BigDecimal("10");
    }

    @Test
    public void testDivide() {
        assertEquals(five, ten.divide(two));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        five.divide(zero);
    }
}

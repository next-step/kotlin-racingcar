package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class CalculatorTest {

    @Test
    fun calculate() {
        var input = CalculationExpression("1 + 2 * 2 + 4")
        assertEquals(10.0, Calculator().calculate(input))

        input = CalculationExpression("14 + 2 * 0 + 4")
        assertEquals(4.0, Calculator().calculate(input))

        input = CalculationExpression("-1 + 2 * 2 + 4")
        assertEquals(6.0, Calculator().calculate(input))

        input = CalculationExpression("-1 - 10 * 2 + 4")
        assertEquals(-18.0, Calculator().calculate(input))
    }

    @Test
    fun addition() {
        assertEquals(3.0, Calculator().addition("1", "2"))
        assertEquals(3.4, Calculator().addition("1.1", "2.3"))
        assertEquals(2.0, Calculator().addition("-1", "3"))
        assertEquals(-4.0, Calculator().addition("-1", "-3"))
    }

    @Test
    fun subtract() {
        assertEquals(1.0, Calculator().subtract("2", "1"))
        assertEquals(-1.2, Calculator().subtract("1.1", "2.3"))
        assertEquals(-4.0, Calculator().subtract("-1", "3"))
        assertEquals(2.0, Calculator().subtract("-1", "-3"))
    }

    @Test
    fun division() {
        assertEquals(2.0, Calculator().division("2", "1"))
        assertEquals(0.48, Calculator().division("1.1", "2.3"))
        assertEquals(-1.0, Calculator().division("-3", "3"))
        assertEquals(3.0, Calculator().division("-3", "-1"))
        assertThrows(IllegalArgumentException::class.java) {
            Calculator().division("3", "0")
        }
    }

    @Test
    fun multiplication() {
        assertEquals(2.0, Calculator().multiplication("2", "1"))
        assertEquals(2.53, Calculator().multiplication("1.1", "2.3"))
        assertEquals(-3.0, Calculator().multiplication("-1", "3"))
        assertEquals(3.0, Calculator().multiplication("-1", "-3"))
    }
}

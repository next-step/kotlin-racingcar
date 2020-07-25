package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun execute() {
        assertEquals(8.5, Calculator.execute(ExpressionParser.parse(" 3 + 4 / 2 + 5 ")))
        assertEquals(-7.0, Calculator.execute(ExpressionParser.parse("-3.5 * 2")))
        assertEquals(Double.NaN, Calculator.execute(ExpressionParser.parse("4 / 0")))
    }
}

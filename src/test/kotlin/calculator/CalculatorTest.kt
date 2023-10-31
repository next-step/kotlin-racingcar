package calculator

import calculator.calculateResult
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun calculateResultTest() {
        assertEquals(10.0, calculateResult("2 + 3 * 4 / 2"))
    }
}

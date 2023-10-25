package calculator.unit

import calculator.Calculator
import calculator.unit.view.InputViewStub
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `사칙연산의 순서는 무시한다`() {
        val calculator = Calculator(InputViewStub("1 + 2 * 3 - 4 / 5"))
        val result = calculator.calculate()
        assertEquals(1, result)
    }
}

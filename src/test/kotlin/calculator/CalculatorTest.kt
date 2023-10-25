package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `사칙연산의 순서는 무시한다`() {
        val calculator = Calculator()
        val result = calculator.calculate("1 + 2 * 3 - 4 / 5")
        assertEquals(1, result)
    }

    @Test
    fun `알 수 없는 연산자가 들어오면 예외가 발생한다`() {
        val calculator = Calculator()
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("1 ^ 2")
        }
    }

    @Test
    fun `공백이 포함된 연산자가 들어오면 예외가 발생한다`() {
        val calculator = Calculator()
        assertThrows(IndexOutOfBoundsException::class.java) {
            calculator.calculate("1 + 2 ")
        }
    }
}

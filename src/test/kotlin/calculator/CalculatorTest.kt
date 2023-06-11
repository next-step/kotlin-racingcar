package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `덧샘 테스트 - Int`() {
        val calculator = Calculator()
        val result = calculator.plus(3, 5)
        assertEquals(8, result)
    }

    @Test
    fun `덧샘 테스트 - Double`() {
        val calculator = Calculator()
        val result = calculator.plus(3, 5)
        assertEquals(8, result)
    }

    @Test
    fun `뺄샘 테스트 - Double`() {
        val calculator = Calculator()
        val result = calculator.minus(3, 5)
        assertEquals(-2, result)
    }

    @Test
    fun `곱셈 테스트 - Double`() {
        val calculator = Calculator()
        val result = calculator.multiply(3, 5)
        assertEquals(15, result)
    }

    @Test
    fun `나눗셈 테스트 - Double`() {
        val calculator = Calculator()
        val result = calculator.divide(3.0, 5.0)
        assertEquals(0.6, result)
    }

    @Test
    fun `Calculator E2E 테스트`() {
        val calculator = Calculator()
        val result = calculator.calculate<Int>("2 + 3 * 4 / 2")
        assertEquals(10, result)
    }

    @Test
    fun `Calculator E2E 테스트 - 유효하지 않은 입력값의 경우 테스트 1`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val calculator = Calculator()
            calculator.calculate<Double>("2 + + 3 * 4 / 2")
        }
        assertEquals("유효한 형식이 아닙니다.", exception.message)
    }

    @Test
    fun `Calculator E2E 테스트 - 유효하지 않은 입력값의 경우 테스트 2`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val calculator = Calculator()
            calculator.calculate<Double>("2 2 + 3 * 4 / 2")
        }
        assertEquals("유효한 형식이 아닙니다.", exception.message)
    }

    @Test
    fun `Calculator E2E 테스트 - 유효하지 않은 입력값의 경우 테스트 3`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val calculator = Calculator()
            calculator.calculate<Double>("")
        }
        assertEquals("유효한 형식이 아닙니다.", exception.message)
    }
}

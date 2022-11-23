package calculator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `더하기 테스트`() {
        // given
        val input = "2 + 3 + 3"
        val result = 2 + 3 + 3

        // when
        val calculator = Calculator()
        val calcResult = calculator.calculate(input)

        // then
        assertTrue(calcResult == result)
    }

    @Test
    fun `빼기 테스트`() {
        val input = "2 - 3"
        val result = 2 - 3

        val calculator = Calculator()
        val calcResult = calculator.calculate(input)

        assertTrue(result == calcResult)
    }

    @Test
    fun `곱하기 테스트`() {
        val input = "3 * 4"
        val result = 3 * 4

        val calculator = Calculator()
        val calcResult = calculator.calculate(input)

        assertTrue(result == calcResult)
    }

    @Test
    fun `나누기 테스트`() {
        val input = "4 / 2"
        val result = 4 / 2

        val calculator = Calculator()
        val calcResult = calculator.calculate(input)

        assertTrue(result == calcResult)
    }

    @Test
    fun `사칙연산 테스트`() {
        // given
        val input = "2 + 3 - 4 * 5 / 2"
        val result = ((2 + 3 - 4) * 5) / 2

        // when
        val calculator = Calculator()
        val calcResult = calculator.calculate(input)

        // then
        assertTrue(result == calcResult)
    }
}

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `사칙연산 기호가 아닌 경우 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("1 , 1")
        }
    }

    @Test
    fun `입력값이 빈 공백일 경우 에러가 발생한다`() {
        val calculator = Calculator()

        listOf("", " ", "\t", "\n").forEach {
            assertThrows<IllegalArgumentException> { calculator.calculate(it) }
        }
    }

    @Test
    fun `사칙연산 문자열을 받아 계산한 값을 반환한다`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("2 + 9 - 1 * 10 / 5")).isEqualTo(20)
    }

    @Test
    fun `연산자와 피연산자를 순서대로 조합해서 계산하고 결과를 리턴한다`() {
        val calculator = Calculator()

        val result = calculator.evaluate(listOf(1, 2, 3), listOf("+", "*"))

        assertThat(result).isEqualTo(9)
    }
}

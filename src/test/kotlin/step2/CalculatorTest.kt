package step2

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    companion object {
        @JvmStatic
        fun complexCalculationProvider() = listOf(
                Arguments { arrayOf("1 + 3 * 5", 20) },
                Arguments { arrayOf("2 - 8 / 3", -2) }
        )
    }

    private val calculator = Calculator()

    @Test
    fun `덧셈 성공`() {
        val result = calculator.calculate("1 + 2")

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `뺄셈 성공`() {
        val result = calculator.calculate("10 - 2")

        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `곱셈 성공`() {
        val result = calculator.calculate("3 * 2")

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `나눗셈 성공`() {
        val result = calculator.calculate("10 / 2")

        assertThat(result).isEqualTo(5)
    }

    @ParameterizedTest
    @MethodSource("complexCalculationProvider")
    fun `사칙 연산을 모두 포함하는 기능 구현`(expression: String, answer: Int) {
        val result = calculator.calculate(expression)

        assertThat(result).isEqualTo(answer)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "      "])
    fun `입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 & 2", "1 + 5 % 1"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate(input)
        }
    }
}
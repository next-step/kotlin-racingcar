package calculator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @Test
    fun `더하기 계산`() {
        val calculator = Calculator()

        val result = calculator.calculate(expression = "2 + 9")

        assertThat(result).isEqualTo(11)
    }

    @Test
    fun `빼기 계산`() {
        val calculator = Calculator()

        val result = calculator.calculate(expression = "2 - 9")

        assertThat(result).isEqualTo(-7)
    }

    @Test
    fun `곱하기 계산`() {
        val calculator = Calculator()

        val result = calculator.calculate(expression = "2 * 9")

        assertThat(result).isEqualTo(18)
    }

    @Test
    fun `나누기 계산`() {
        val calculator = Calculator()

        val result = calculator.calculate(expression = "10 / 2")

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `일반 수식이 들어오면 계산이 된다`() {
        val calculator = Calculator()

        val result = calculator.calculate(expression = "2 + 3 * 4 / 2")

        assertThat(result).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?) {
        val calculator = Calculator()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate(expression = input)
            }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1",
            "a",
            "#",
            "1#2",
            "*21",
            "12*",
            "123",
            "*+-"
        ]
    )
    fun `사칙 연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String?) {
        val calculator = Calculator()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate(expression = input)
            }
    }
}

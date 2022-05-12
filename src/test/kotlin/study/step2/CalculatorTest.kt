package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class CalculatorTest {

    @Test
    fun `number와 operator를 분리할 수 있다 - 1`() {
        val expression = "1 + 1"

        val (operands, operators) = Calculator.splitNumbersAndOperators(expression)

        assertThat(operands).isEqualTo(listOf(1.0, 1.0))
        assertThat(operators).isEqualTo(listOf("+"))
    }

    @Test
    fun `number와 operator를 분리할 수 있다 - 2`() {
        val expression = "1 + 2 - 3 * 4 / 5"

        val (operands, operators) = Calculator.splitNumbersAndOperators(expression)

        assertThat(operands).isEqualTo(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
        assertThat(operators).isEqualTo(listOf("+", "-", "*", "/"))
    }

    @ParameterizedTest
    @MethodSource("expressionArguments")
    fun `사칙연산을 할 수 있다`(expression: String, answer: Double) {
        val result = Calculator.calculate(expression)

        assertThat(result).isEqualTo(answer)
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", "  ", "1 / 0"])
    fun `올바르지 않은 표현식은 exception이 발생한다`(input: String?) {
        assertThrows<IllegalArgumentException> { Calculator.calculate(input) }
        assertThatThrownBy {
            Calculator.calculate(input)
        }.isExactlyInstanceOf(java.lang.IllegalArgumentException::class.java)
            .hasMessage("잘못된 계산식 입니다")
    }

    companion object {
        @JvmStatic
        fun expressionArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "1 + 1",
                    2.0
                ),
                Arguments.of(
                    "2 + 2",
                    4.0
                ),
                Arguments.of(
                    "1111 - 111",
                    1000.0
                ),
                Arguments.of(
                    "11 * 11",
                    121.0
                ),
                Arguments.of(
                    "5 / 2",
                    2.5
                ),
                Arguments.of(
                    "1 + 2 - 3 * 4 / 5",
                    0.0
                )
            )
        }
    }
}

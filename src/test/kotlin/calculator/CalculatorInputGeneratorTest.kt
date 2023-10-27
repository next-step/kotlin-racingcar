@file:Suppress("NonAsciiCharacters")

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorInputGeneratorTest {
    @Test
    fun `generate - 문자열 입력값이 주어지면 공백을 기준으로 구분하여 연산자와 피연산자 리스트를 반환한다`() {
        val input = "2 + 3 * 4"

        val result = CalculatorInputGenerator.generate(input)

        assertThat(result).usingRecursiveComparison()
            .isEqualTo(
                CalculatorInput(
                    operands = listOf(2.0, 3.0, 4.0),
                    operators = listOf(Operator.PLUS, Operator.MULTIPLY),
                )
            )
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " "])
    fun `generate - 입력값이 null이거나 빈 공백 문자열일 경우 IllegalArgumentException을 던진다`(input: String?) {
        val result = catchThrowable {
            CalculatorInputGenerator.generate(input)
        }

        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input should not be null or blank.")
    }

    @Test
    fun `generate - 공백으로 구분한 입력값에서 홀수 번째 위치에 숫자가 아닌 문자가 있으면 NumberFormatException을 던진다`() {
        val input = "2 + *"

        val result = catchThrowable {
            CalculatorInputGenerator.generate(input)
        }

        assertThat(result).isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `generate - 공백으로 구분한 입력값에서 짝수 번째 위치에 사칙연산자가 아닌 문자가 있으면 IllegalArgumentException을 던진다`() {
        val input = "2 % 4"

        val result = catchThrowable {
            CalculatorInputGenerator.generate(input)
        }

        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input can only contain four basic operators.")
    }
}

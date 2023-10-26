@file:Suppress("NonAsciiCharacters")

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

class CalculatorInputParserTest {
    private val sut = CalculatorInputParser()

    @Test
    fun `parse - 문자열 입력값이 주어지면 공백을 기준으로 구분하여 연산자와 피연산자 리스트를 반환한다`() {
        val input = "2 + 3 * 4"

        val result = sut.parse(input)

        assertThat(result).isEqualTo(
            CalculatorInputParseResult(
                operands = listOf(2.0, 3.0, 4.0),
                operators = listOf(Operator.PLUS, Operator.MULTIPLY),
            )
        )
    }

    @Test
    fun `parse - 공백으로 구분한 입력값에서 홀수 번째 위치에 숫자가 아닌 문자가 있으면 NumberFormatException을 던진다`() {
        val input = "2 + *"

        val result = catchThrowable {
            sut.parse(input)
        }

        assertThat(result).isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `parse - 공백으로 구분한 입력값에서 짝수 번째 위치에 사칙연산자가 아닌 문자가 있으면 IllegalArgumentException을 던진다`() {
        val input = "2 % 4"

        val result = catchThrowable {
            sut.parse(input)
        }

        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input can only contain four basic operators.")
    }

    @Test
    fun `parse - 공백으로 구분한 입력값에서 피연산자 수가 연산자 수 + 1이 아니면 IllegalArgumentException을 던진다`() {
        val input = "2 / 4 +"

        val result = catchThrowable {
            sut.parse(input)
        }

        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Number of operands should be one more than number of operators.")
    }
}

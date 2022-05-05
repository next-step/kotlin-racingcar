package calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @Test
    fun `입력값이 null 인 경우 에러가 발생한다`() {
        // given
        val nullInput = null

        // then
        assertThatThrownBy {
            Calculator(nullInput)
        }.hasMessage(ErrorMessage.NULL_INPUT_ERROR)
    }

    @Test
    fun `입력값이 공백인 경우 에러가 발생한다`() {
        // given
        val spaceInput = "    "

        // then
        assertThatThrownBy {
            Calculator(spaceInput)
        }.hasMessage(ErrorMessage.SPACE_INPUT_ERROR)
    }

    @Test
    fun `입력값에 사칙연산이 아닌 기호가 포함된 경우 에러가 발생한다`() {
        // given
        val input = "1 + 1 _@!#"

        // then
        assertThatThrownBy {
            Calculator(input)
        }.hasMessage(ErrorMessage.OTHER_STRING_INPUT_ERROR)
    }

    @Test
    fun `입력값에 연산자가 연속으로 두번 나온 경우 에러가 발생한다`() {
        // given
        val input = "1++1"

        // then
        assertThatThrownBy {
            Calculator(input)
        }.hasMessage(ErrorMessage.NOT_MATCH_OPERAND_COUNT)
    }

    @Test
    fun `2 + 3 x 4  ÷ 2 를 입력하면 10이 나온다`() {
        // given
        val input = "2 + 3 * 4  / 2"

        // when
        val result = Calculator(input).calculation()

        // then
        assertThat(result).isEqualTo(10.0)
    }

    @Test
    fun `공백이 포함된 입력 값인 '2    0  +  1   0 ' 이 입력된 경우 30이 나온다`() {
        // given
        val input = "2    0  +  1   0 "

        // when
        val result = Calculator(input).calculation()

        // then
        assertThat(result).isEqualTo(30.0)
    }

    @ParameterizedTest(name = " {0} 을 계산하면 {1} 값이 나온다")
    @CsvSource(
        value = [
            "1 + 2, 3.0",
            "4 - 3, 1.0",
            "7 * 8, 56.0",
            "10 / 5, 2.0"
        ]
    )
    fun `사칙연산이 정상적으로 수행된다`(arithmeticExpression: String, successValue: Double) {
        // when
        val result = Calculator(arithmeticExpression).calculation()

        // then
        assertThat(result).isEqualTo(successValue)
    }
}

package calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculationParameterTest {

    @Test
    fun `calculationParameter 는 연산자, 피연산자를 나누어서 가지고 있다`() {
        // given
        val input = "1 + 2"

        // when
        val calculationParameter = CalculationParameter(input)

        // then
        assertThat(calculationParameter.operators[0]).isEqualTo(Operator.PLUS)
        assertThat(calculationParameter.operands).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `입력값에 공백이 포함되어 있어도 정상적으로 연산자, 피연산자를 구분할수 있다`() {
        // given
        val input = "1   0 + 2    0 -  3   0 /   4  5   * 6  7"

        // when
        val calculationParameter = CalculationParameter(input)

        // then
        assertThat(calculationParameter.operators).containsExactly(
            Operator.PLUS, Operator.MINUS, Operator.DIVISION, Operator.MULTIPLICATION
        )
        assertThat(calculationParameter.operands).containsExactly(10, 20, 30, 45, 67)
    }

    @Test
    fun `validateExpression 은 입력값이 공백인 경우 에러가 발생한다`() {
        // given
        val spaceInput = "    "

        // then
        assertThatThrownBy {
            CalculationParameter.validateExpression(spaceInput)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage(ErrorMessage.SPACE_INPUT_ERROR)
    }

    @Test
    fun `validateExpression 은 입력값에 사칙연산이 아닌 기호가 포함된 경우 에러가 발생한다`() {
        // given
        val input = "1 + 1 _@!#"

        // then
        assertThatThrownBy {
            CalculationParameter.validateExpression(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage(ErrorMessage.OTHER_STRING_INPUT_ERROR)
    }

    @Test
    fun `validateExpression 은 입력값에 연산자가 연속으로 두번 나온 경우 에러가 발생한다`() {
        // given
        val input = "1++1"

        // then
        assertThatThrownBy {
            CalculationParameter.validateExpression(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage(ErrorMessage.NOT_MATCH_OPERAND_COUNT)
    }
}

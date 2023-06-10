package calculator

import calculator.Operand.Companion.toOperand
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class FormulaElementsTest {
    @Test
    fun `문자열 식을 변환할 수 있다`() {
        // given
        val formula = "1 + 2"

        // when
        val result = FormulaElements(formula.split(" "))

        // then
        assertThat(result.startValue).isEqualTo(1.0.toOperand())
        assertThat(result.nextFormulaElement()).isEqualTo(2.0.withOperation(Operation.PLUS))
        assertThat(result.nextFormulaElement()).isNull()
    }

    @Test
    fun `0 으로 나누는 문자열 식은 변환될 수 없다`() {
        // given
        val formula = "1 / 0"

        // when

        // then
        Assertions.assertThatThrownBy {
            FormulaElements(formula.split(" "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자가 포함되지 않은 문자열이 전달된다면 예외가 발생한다`() {
        // given
        val noFormulaString = " "
        // when
        // then
        Assertions.assertThatThrownBy {
            FormulaElements(noFormulaString.split(" "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백을 기준으로 문자열을 분리했을 때 짝수번째 위치한 값이 수가 아니라면 예외가 발생한다`() {
        // given
        val formulaString = "1 + +"
        // when
        // then
        Assertions.assertThatThrownBy {
            FormulaElements(formulaString.split(" "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백을 기준으로 문자열을 분리했을 때 홀수번째 위치한 값이 Operation 에 해당하지 않는다면 예외가 발생한다`() {
        // given
        val formulaString = "1 x 1"
        // when
        // then
        Assertions.assertThatThrownBy {
            FormulaElements(formulaString.split(" "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백을 기준으로 문자열을 분리했을때 짝수개로 분리된다면 예외가 발생한다`() {
        // given
        val formulaString = "1 + 1 -"
        // when
        // then
        Assertions.assertThatThrownBy {
            FormulaElements(formulaString.split(" "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    private fun Double.withOperation(operation: Operation): FormulaElement = FormulaElement(toOperand(), operation)
}

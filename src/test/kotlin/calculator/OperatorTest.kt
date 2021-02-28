package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import calculator.data.Operand
import calculator.data.Operator
import calculator.util.Message.Companion.NOTICE_NOT_OPERATOR_SYMBOL

@Suppress("NonAsciiCharacters")
class OperatorTest {

    @CsvSource("+,ADD", "-,MINUS", "*,MULTIPLY", "/,DIVIDE")
    @ParameterizedTest
    fun `enum 이 제대로 설계되었는지 체크`(operatorSymbol: String, operator: Operator) {
        assertThat(Operator.findByOperatorSymbol(operatorSymbol)).isEqualTo(operator)
    }

    @Test
    fun `유효한 연산 기호인지 체크`() {
        val operatorSymbol = ")"
        assertThatThrownBy { Operator.findByOperatorSymbol(operatorSymbol) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(operatorSymbol.plus(NOTICE_NOT_OPERATOR_SYMBOL))
    }

    @CsvSource("1,4,ADD,5", "3,3,MINUS,0", "2,4,MULTIPLY,8", "12,1,DIVIDE,12")
    @ParameterizedTest
    fun `사칙연산이 전략패턴에 의해 제대로 수행되는 지 체크`(value1: Double, value2: Double, operator: Operator, result: Double) {
        val operand1 = Operand(value1)
        val operand2 = Operand(value2)

        val expectedOperand = operator.calculate(operand1, operand2)

        assertThat(expectedOperand).isEqualTo(Operand(result))
    }
}

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import calculator.data.Operand
import calculator.data.Operator
import calculator.util.Const.Companion.NOTICE_NOT_OPERATOR_SYMBOL

class OperatorTest {

    @CsvSource("+,ADD", "-,MINUS", "*,MULTIPLY", "/,DIVIDE")
    @ParameterizedTest
    fun `연산 기호 유효 체크`(operatorSymbol: String, operator: Operator) {
        assertThat(Operator.findByOperatorSymbol(operatorSymbol)).isEqualTo(operator)
    }

    @Test
    fun `연산 기호 유효 체크`() {
        val operatorSymbol = ")"
        assertThatThrownBy { Operator.findByOperatorSymbol(operatorSymbol) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(operatorSymbol.plus(NOTICE_NOT_OPERATOR_SYMBOL))
    }

    @CsvSource("1,4,ADD,5", "3,3,MINUS,0", "2,4,MULTIPLY,8", "12,1,DIVIDE,12")
    @ParameterizedTest
    fun `모든 연산 전략 체크`(value1: Double, value2: Double, operator: Operator, result: Double) {
        val operand1 = Operand(value1)
        val operand2 = Operand(value2)

        val expectedOperand = operator.calculate(operand1, operand2)

        assertThat(expectedOperand).isEqualTo(Operand(result))
    }
}

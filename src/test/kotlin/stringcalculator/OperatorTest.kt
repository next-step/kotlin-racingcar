package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {

    @CsvSource("+,ADD", "-,MINUS", "*,MULTIPLY", "/,DIVIDE")
    @ParameterizedTest
    fun `유효한 연산 기호 찾는지 확인`(symbol: String, operator: Operator) {
        // then
        assertThat(Operator.findBySymbol(symbol)).isEqualTo(operator)
    }

    @Test
    fun `유효하지 않은 연산 기호 넣을 시 Exception`() {
        // then
        assertThatThrownBy { Operator.findBySymbol("!") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("! 기호에 해당하는 연산은 존재하지 않습니다.")
    }

    @CsvSource("1,2,ADD,3", "3,1,MINUS,2", "2,4,MULTIPLY,8", "12,3,DIVIDE,4")
    @ParameterizedTest
    fun `계산 전략에 따른 계산 결과 확인`(value1: Double, value2: Double, operator: Operator, result: Double) {
        // given
        val operand1 = Operand(value1)
        val operand2 = Operand(value2)

        // when
        val expectedOperand = operator.calculate(operand1, operand2)

        // then
        assertThat(expectedOperand).isEqualTo(Operand(result))
    }
}

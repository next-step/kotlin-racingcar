package calculator.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class OperandTest {

    @Test
    @DisplayName("입력받은 문자열을 Operand 클래스로 만든다.")
    fun operandOf() {
        val operand = Operand.of("3")
        assertThat(3.0).isEqualTo(operand.number)
    }

    @Test
    @DisplayName("올바르지 않은 문자열을 Operand로 만들려 하면 에러가 발생한다")
    fun invalidOperand() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Operand.of("=") }
    }

    @Test
    @DisplayName("연산자 오버라이딩을 이용해 Operand 산술 연산이 가능하다.")
    fun operatorExecute() {
        val operand1 = Operand(6.0)
        val operand2 = Operand(2.0)

        val plus = operand1 + operand2
        val minus = operand1 - operand2
        val multiple = operand1 * operand2
        val divide = operand1 / operand2

        assertThat(plus.number).isEqualTo(8.0)
        assertThat(minus.number).isEqualTo(4.0)
        assertThat(multiple.number).isEqualTo(12.0)
        assertThat(divide.number).isEqualTo(3.0)
    }
}

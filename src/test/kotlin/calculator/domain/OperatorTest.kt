package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OperatorTest {

    @Test
    @DisplayName("나누기를 했을 때 0으로 나누면 에러를 발생시킨다")
    fun execute() {
        assertThatIllegalArgumentException()
            .isThrownBy { Operator.DIVIDE.operation(Operand(2.0), Operand(0.0)) }
    }

    @Test
    @DisplayName("문자열을 받으면 해당하는 연산자 타입을 반환한다")
    fun getValue() {
        val plus = Operator.of("+")
        assertThat(plus).isEqualTo(Operator.PLUS)
    }

    @Test
    @DisplayName("Operator에 해당하는 연산을 수행한다.")
    fun operatorExecute() {
        val operand1 = Operand(6.0)
        val operand2 = Operand(2.0)

        val plus = Operator.PLUS.operation(operand1, operand2)
        val minus = Operator.MINUS.operation(operand1, operand2)
        val multiple = Operator.MULTIPLE.operation(operand1, operand2)
        val divide = Operator.DIVIDE.operation(operand1, operand2)

        assertThat(plus.number).isEqualTo(8.0)
        assertThat(minus.number).isEqualTo(4.0)
        assertThat(multiple.number).isEqualTo(12.0)
        assertThat(divide.number).isEqualTo(3.0)
    }
}

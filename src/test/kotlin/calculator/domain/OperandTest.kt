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
}

package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OperandTest {

    @DisplayName("올바른 피연산자 타입이 아닐경우 에러 반환")
    @Test
    fun `올바른 피연산자 타입이 아닐경우 에러 반환`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Operand.from("+") }
            .withMessage("올바르지 않은 피연산자 타입입니다")
    }

    @DisplayName("정상적으로 값이 들어간 케이스")
    @Test
    fun `정상적으로 값이 들어간 케이스`() {
        assertThat(Operand.from("1").number).isEqualTo(1.0)
    }
}

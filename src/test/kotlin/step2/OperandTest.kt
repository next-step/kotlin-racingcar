package step2

import calculator.Operand
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.ThrowableAssert.ThrowingCallable
import org.junit.jupiter.api.Test

class OperandTest {
    @Test
    fun `문자열이 정수면 값을 프로퍼티로 갖고있다`() {
        // given
        val actual = Operand.of("12")
        // then
        assertThat(actual.value).isEqualTo(12)
    }

    @Test
    fun `문자열이 정수가 아니면 예외를 발생한다`() {
        // given
        val throwingCallable = ThrowingCallable {
            Operand.of("+")
        }
        // then
        assertThatIllegalArgumentException().isThrownBy(throwingCallable).withMessage("invalid operand")
    }
}

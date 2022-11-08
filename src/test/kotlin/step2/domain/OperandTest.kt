package step2.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OperandTest {
    @DisplayName("생성자 테스트")
    @Test
    fun `생성자 테스트`() {
        assertThat(Operand(1)).isEqualTo(Operand(1))
    }

    @DisplayName("음수 예외처리 테스트")
    @Test
    fun `음수 예외처리 테스트`() {
        Assertions.assertThatThrownBy { Operand(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}

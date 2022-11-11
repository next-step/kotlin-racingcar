package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {
    @DisplayName("생성자 테스트")
    @Test
    fun `생성자 테스트`() {
        assertThat(Operand(1)).isEqualTo(Operand(1))
    }

    @DisplayName("음수 예외처리 테스트")
    @Test
    fun `음수 예외처리 테스트`() {
        assertThatThrownBy { Operand(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("보조 생성자 테스트")
    @Test
    fun `보조 생성자 테스트`() {
        assertThat(Operand("1")).isEqualTo(Operand("1"))
    }

    @DisplayName("보조 생성자 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "a", "1a", "Hannah"])
    fun `보조 생성자 예외 처리 테스트`(input: String) {
        assertThatThrownBy { Operand(input) }
            .isInstanceOf(NumberFormatException::class.java)
    }
}

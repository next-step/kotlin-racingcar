package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `유효한 문자열 넣을 시 결과 확인`() {
        // given
        val splitString = "2 + 3 * 4 / 2".split(" ")

        // then
        assertThat(StringCalculator.calculate(splitString))
            .isEqualTo(Operand(10.0))
    }

    @Test
    fun `공백문자 넣을 시 Exception`() {
        // given
        val splitString = " ".split(" ")

        // then
        assertThatThrownBy { StringCalculator.calculate(splitString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력 문자는 공백 일 수 없습니다.")
    }
}

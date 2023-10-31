package calculator.application

import calculator.application.port.`in`.CalculateCommand
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculateCommandTest {

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우`() {
        // given
        val nullInput: String? = null
        val blankInput = ""

        // then
        assertThatThrownBy { CalculateCommand(nullInput) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { CalculateCommand(blankInput) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        // given
        val input = "1 & 1"

        // then
        assertThatThrownBy { CalculateCommand(input) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

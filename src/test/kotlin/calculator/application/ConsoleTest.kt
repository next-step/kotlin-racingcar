package calculator.application

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ConsoleTest {
    private val console: Console = Console()

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우`() {
        //given
        val nullInput: String? = null
        val blankInput = ""

        //then
        assertThatThrownBy { console.isValidInput(nullInput) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { console.isValidInput(blankInput) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        //given
        val input = "1 & 1"

        //then
        assertThatThrownBy { console.isValidInput(input) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

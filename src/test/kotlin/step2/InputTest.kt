package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class InputTest {

    private val input = Input()

    @Test
    fun `공백이나 빈 문자열 입력`() {
        assertThatThrownBy { input.checkFormulaValidation("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { input.checkFormulaValidation(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `문자열을 리스트로 변환`() {
        assertThat(input.convertFormulaToList("5 + 5 * 2")).isEqualTo(listOf("5", "+", "5", "*", "2"))
        assertThat(input.convertFormulaToList("   5 + 5 * 2")).isEqualTo(listOf("5", "+", "5", "*", "2"))
        assertThat(input.convertFormulaToList("5 + 5 * 2   ")).isEqualTo(listOf("5", "+", "5", "*", "2"))
        assertThat(input.convertFormulaToList("5 + 5 * 2 -  3")).isEqualTo(listOf("5", "+", "5", "*", "2", "-", "3"))
    }
}

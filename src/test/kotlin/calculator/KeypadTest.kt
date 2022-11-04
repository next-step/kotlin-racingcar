package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class KeypadTest {
    @Test
    fun `입력받지 않으면(null) IllegalArgumentException 던진다`() {
        assertThrows<IllegalArgumentException> { Keypad().pressed(null) }
    }

    @Test
    fun `공백(" ")을 입력받으면 IllegalArgumentException 던진다`() {
        assertThrows<IllegalArgumentException> { Keypad().pressed(" ") }
    }

    @Test
    fun `빈 문자열("")을 입력받으면 IllegalArgumentException 던진다`() {
        assertThrows<IllegalArgumentException> { Keypad().pressed("") }
    }

    @Test
    fun `위의 것을 제외한 문자열을 입력하면 그대로 반환한다`() {
        val inputText = "11"
        Assertions.assertThat(Keypad().pressed(inputText)).isEqualTo(inputText)
    }
}

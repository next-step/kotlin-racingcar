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
    fun `입력된 문자를 공백단위로 분리하여 배열로 반환한다`() {
        val inputText = "11 + 1"
        Assertions.assertThat(Keypad().pressed(inputText)).isEqualTo(listOf("11", "+", "1"))
    }

    @Test
    fun `공백이 없더라도 배열에 담겨 반환된다`() {
        val inputText = "11"
        Assertions.assertThat(Keypad().pressed(inputText)).isEqualTo(listOf("11"))
    }
}

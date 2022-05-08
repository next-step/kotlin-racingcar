package step3.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `입력값이 null이면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validate(null)
        }
    }

    @Test
    fun `입력값이 Int로 변환될 수 없으면 NumberFormatException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validate("ㅋㅋ")
        }
    }

    @Test
    fun `입력값이 0보다 작으면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validate("-1")
        }
    }
}
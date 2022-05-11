package racinggame.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameLengthValidatorTest {
    @Test
    fun `입력값의 길이가 5를 초과하면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NameLengthValidator.validate("austen")
        }
    }
}
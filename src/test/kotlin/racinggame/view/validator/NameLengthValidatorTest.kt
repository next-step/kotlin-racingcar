package racinggame.view.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class NameLengthValidatorTest {
    @Test
    fun `입력값의 길이가 5를 초과하는 이름이 존재하면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NameLengthValidator.validate(listOf("panther", "violet", "sophie"))
        }
    }

    @Test
    fun `모든 이름이 길이가 5 이하면 Exception이 발생하지 않는다`() {
        assertDoesNotThrow {
            NameLengthValidator.validate(
                listOf("joker", "mona", "skull", "fox", "queen", "navi", "noir", "crow", "wolf")
            )
        }
    }
}

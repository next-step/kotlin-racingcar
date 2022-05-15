package racinggame.view.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberRangeValidatorTest {
    @Test
    fun `입력값이 0보다 작으면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NumberRangeValidator.validate(-1)
        }
    }
}

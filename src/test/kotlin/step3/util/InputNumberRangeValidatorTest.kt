package step3.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputNumberRangeValidatorTest {
    @Test
    fun `입력값이 0보다 작으면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputNumberRangeValidator.validate(-1)
        }
    }
}

package study.racingcar.step4

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarValidationTest {

    @Test
    fun `이름 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            CarValidation().validationCarNameLength("aaaaaa")
        }
    }
}

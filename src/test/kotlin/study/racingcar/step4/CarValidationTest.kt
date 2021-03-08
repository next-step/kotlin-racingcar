package study.racingcar.step4

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.racingcar.step4.domain.CarValidation

class CarValidationTest {

    @Test
    fun `이름 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            CarValidation().validationCarNameLength("aaaaaa")
        }
    }
}

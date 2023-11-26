package carracing

import carracing.domain.CarRacingValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarRacingValidatorTest {
    @Test
    fun `자동차 이름 5자 초과시 예외 발생`() {
        val carName = "carNameOver"
        assertThrows(IllegalArgumentException::class.java) {
            CarRacingValidator().validateCarName(carName)
        }
    }
}
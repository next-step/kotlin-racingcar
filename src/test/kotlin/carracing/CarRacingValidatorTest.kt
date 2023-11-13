package carracing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarRacingValidatorTest {
    @Test
    fun `자동차 이름 5자 초과`() {
        val carName = "carNameOver"
        assertThrows(IllegalArgumentException::class.java) {
            CarRacingValidator().validateCarName(carName)
        }
    }
}
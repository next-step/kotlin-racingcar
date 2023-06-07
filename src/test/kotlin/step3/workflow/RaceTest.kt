package step3.workflow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import step3.entity.RacingCar

internal class RaceTest {
    @Test
    fun `if condition is true, then move forward`() {
        val race = Race { true }
        val racingCar = RacingCar()
        val movedRacingCar = race(racingCar)
        assertEquals(1, movedRacingCar.position)
    }

    @Test
    fun `if condition is false, then move forward`() {
        val race = Race { false }
        val racingCar = RacingCar()
        val movedRacingCar = race(racingCar)
        assertEquals(0, movedRacingCar.position)
    }
}

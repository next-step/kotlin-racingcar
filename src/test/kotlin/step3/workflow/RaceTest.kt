package step3.workflow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import step3.entity.RacingCar

internal class RaceTest {
    @Test
    fun `if condition is true, then move forward`() {
        val race = Race { true }
        val racingCar = RacingCar.makeCars(listOf("jeff"))
        val movedRacingCar = race(racingCar)
        assertEquals(1, movedRacingCar[0].position)
    }

    @Test
    fun `if condition is false, then it does not move`() {
        val race = Race { false }
        val racingCar = RacingCar.makeCars(listOf("jeff"))
        val movedRacingCar = race(racingCar)
        assertEquals(0, movedRacingCar[0].position)
    }
}

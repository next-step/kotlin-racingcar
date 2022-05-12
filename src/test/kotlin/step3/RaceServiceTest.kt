package step3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import step3.car.Car
import step3.common.CarRaceProperty
import step3.race.RaceService

class RaceServiceTest {

    @Test
    fun `이동 불가능한 케이스 테스트`() {
        val carRaceProperty = CarRaceProperty()
        val raceService = RaceService(carRaceProperty)
        Assertions.assertFalse(raceService.canBeMove(3))
    }

    @Test
    fun `이동 가능한 케이스 테스트`() {
        val carRaceProperty = CarRaceProperty()
        val raceService = RaceService(carRaceProperty)
        Assertions.assertTrue(raceService.canBeMove(7))
    }

    @Test
    fun `이동이 되었는지 테스트`() {
        val carRaceProperty = CarRaceProperty()
        val car1 = Car(1, 0)
        carRaceProperty.car[1] = car1

        val raceService = RaceService(carRaceProperty)
        raceService.move(car1)

        assertEquals(carRaceProperty.car[1]?.moveCount, 1)
    }
}

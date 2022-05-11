package step3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import step3.CarRaceConst.car
import step3.car.Car
import step3.race.RaceService

class RaceServiceTest {

    @Test
    fun `이동 불가능한 케이스 테스트`() {

        val raceService = RaceService()
        Assertions.assertFalse(raceService.canBeMove(3))
    }

    @Test
    fun `이동 가능한 케이스 테스트`() {

        val raceService = RaceService()
        Assertions.assertTrue(raceService.canBeMove(7))
    }

    @Test
    fun `이동이 되었는지 테스트`() {
        val car1 = Car(1, 0)
        car[1] = car1
        val raceService = RaceService()
        raceService.move(car1)

        assertEquals(car[1]?.moveCount, 1)
    }
}

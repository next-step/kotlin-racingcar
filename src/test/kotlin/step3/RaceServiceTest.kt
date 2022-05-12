package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.car.Car
import step3.common.CarRaceProperty
import step3.race.RaceService

class RaceServiceTest {

    @Test
    fun `이동 불가능한 케이스 테스트`() {
        val carRaceProperty = CarRaceProperty()
        val raceService = RaceService(carRaceProperty)

        assertThat(raceService.canBeMove(3)).isEqualTo(false)
    }

    @Test
    fun `이동 가능한 케이스 테스트`() {
        val carRaceProperty = CarRaceProperty()
        val raceService = RaceService(carRaceProperty)

        assertThat(raceService.canBeMove(7)).isEqualTo(true)
    }

    @Test
    fun `이동이 되었는지 테스트`() {
        val carRaceProperty = CarRaceProperty()
        val car1 = Car(1, 0)
        carRaceProperty.car[1] = car1

        val raceService = RaceService(carRaceProperty)
        raceService.move(car1)

        assertThat(carRaceProperty.car[1]?.moveCount).isEqualTo(1)
    }
}

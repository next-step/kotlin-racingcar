package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    private lateinit var race: Race

    @Test
    fun `차량들 이동 확인`() {
        // given
        race = Race(5,5)

        // when
        race.confirmMoveOfCars { true }

        // then
        race.cars.cars.forEach {
            assertThat(it.carPosition()).isEqualTo(5)
        }
    }
}

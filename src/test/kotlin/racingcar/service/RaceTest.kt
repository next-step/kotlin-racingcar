package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    private lateinit var race: Race

    @Test
    fun `차량들 이동 확인`() {
        // given
        race = Race("자동차1,자동차2,자동차3,자동차4,자동차5", 5)

        // when
        race.confirmMoveOfCars { true }

        // then
        race.cars.cars.forEach {
            assertThat(it.carPosition()).isEqualTo(5)
        }
    }
}

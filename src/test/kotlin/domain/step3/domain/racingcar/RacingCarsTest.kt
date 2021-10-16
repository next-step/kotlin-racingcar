package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarsTest {

    @Test
    fun `RacingCars 조건 만족시 이동 테스트`() {
        val movingStrategy = { true }

        val racingCars = RacingCars(
            listOf(
                RacingCar(movingStrategy = movingStrategy),
                RacingCar(movingStrategy = movingStrategy)
            )
        )

        val expected = RacingCars(
            listOf(
                RacingCar(DistanceDriven(1), movingStrategy),
                RacingCar(DistanceDriven(1), movingStrategy)
            )
        )

        val movedRacingCars = racingCars.moveForward()
        assertThat(movedRacingCars).isEqualTo(expected)
    }
}

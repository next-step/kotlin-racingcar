package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarsTest {

    @Test
    fun `RacingCars 조건 만족시 이동 테스트`() {
        val racingCars = RacingCars(listOf(RacingCar { true }, RacingCar { true }))
        val expected = RacingCars(
            listOf(
                RacingCar(DistanceDriven(1)) { true },
                RacingCar(DistanceDriven(1)) { true }
            )
        )

        val movedRacingCars = racingCars.moveForward()

        assertThat(movedRacingCars).isEqualTo(expected)
    }
}

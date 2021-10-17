package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarsTest {

    @Test
    fun `RacingCars 가 조건을 만족한다면 이동한다`() {
        val movingStrategy = { true }

        val racingCars = RacingCars(
            listOf(
                RacingCar(movingStrategy = movingStrategy),
                RacingCar(movingStrategy = movingStrategy)
            )
        )

        val expected = RacingCars(
            listOf(
                RacingCar(DistanceDriven(2), movingStrategy),
                RacingCar(DistanceDriven(2), movingStrategy)
            )
        )

        val movedRacingCars = racingCars.moveForward()
        assertThat(movedRacingCars).isEqualTo(expected)
    }

    @Test
    fun `RacingCars 가 조건을 만족하지 않는다면 이동하지 않는다`() {
        val movingStrategy = { false }

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

    @Test
    fun `RacingCars 중에 조건을 만족는 자동차만 이동한다`() {
        val falseMovingStrategy = { false }
        val trueMovingStrategy = { true }

        val racingCars = RacingCars(
            listOf(
                RacingCar(movingStrategy = falseMovingStrategy),
                RacingCar(movingStrategy = trueMovingStrategy)
            )
        )

        val expected = RacingCars(
            listOf(
                RacingCar(DistanceDriven(1), falseMovingStrategy),
                RacingCar(DistanceDriven(2), trueMovingStrategy)
            )
        )

        val movedRacingCars = racingCars.moveForward()
        assertThat(movedRacingCars).isEqualTo(expected)
    }

}

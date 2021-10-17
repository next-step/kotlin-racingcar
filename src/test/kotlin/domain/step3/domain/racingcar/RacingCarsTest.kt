package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarsTest {

    @Test
    fun `자동차 경주 참가 수가 들어오면 RacingCars 가 생성 된다`() {
        // given
        val movingStrategy = { true }
        val expected = RacingCars(
            listOf(
                RacingCar(movingStrategy = movingStrategy),
                RacingCar(movingStrategy = movingStrategy)
            )
        )

        // when
        val racingCars = RacingCars.from(2, movingStrategy)

        // then
        assertAll(
            { assertThat(racingCars).isNotNull },
            { assertThat(racingCars).isExactlyInstanceOf(RacingCars::class.java) },
            { assertThat(racingCars).isEqualTo(expected) },
        )
    }

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

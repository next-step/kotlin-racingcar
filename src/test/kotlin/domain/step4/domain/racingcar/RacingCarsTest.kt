package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarsTest {

    @Test
    fun `자동차 경주 참가 수가 들어오면 RacingCars 가 생성 된다`() {
        val movingStrategy = { true }
        val splitStrategy = { target: String -> target.split(",") }

        val name = Name("test")

        val expected = RacingCars.of(
            listOf(
                RacingCar(name, movingStrategy = movingStrategy),
                RacingCar(name, movingStrategy = movingStrategy)
            )
        )

        val racingCars = RacingCars.from("test,test", splitStrategy, movingStrategy)

        assertAll(
            { assertThat(racingCars).isNotNull },
            { assertThat(racingCars).isExactlyInstanceOf(RacingCars::class.java) },
            { assertThat(racingCars).isEqualTo(expected) },
        )
    }

    @Test
    fun `RacingCars 가 조건을 만족한다면 이동한다`() {
        val movingStrategy = { true }
        val name = Name("test")

        val racingCars = RacingCars.of(
            listOf(
                RacingCar(name, movingStrategy = movingStrategy),
                RacingCar(name, movingStrategy = movingStrategy)
            )
        )

        val expected = RacingCars.of(
            listOf(
                RacingCar(name, DistanceDriven(1), movingStrategy),
                RacingCar(name, DistanceDriven(1), movingStrategy)
            )
        )

        val movedRacingCars = racingCars.moveForward()
        assertThat(movedRacingCars).isEqualTo(expected)
    }

    @Test
    fun `RacingCars 가 조건을 만족하지 않는다면 이동하지 않는다`() {
        val movingStrategy = { false }
        val name = Name("test")

        val racingCars = RacingCars.of(
            listOf(
                RacingCar(name, movingStrategy = movingStrategy),
                RacingCar(name, movingStrategy = movingStrategy)
            )
        )

        val expected = RacingCars.of(
            listOf(
                RacingCar(name, DistanceDriven(0), movingStrategy),
                RacingCar(name, DistanceDriven(0), movingStrategy)
            )
        )

        val movedRacingCars = racingCars.moveForward()
        assertThat(movedRacingCars).isEqualTo(expected)
    }

    @Test
    fun `RacingCars 중에 조건을 만족는 자동차만 이동한다`() {
        val falseMovingStrategy = { false }
        val trueMovingStrategy = { true }
        val name = Name("test")

        val racingCars = RacingCars.of(
            listOf(
                RacingCar(name, movingStrategy = falseMovingStrategy),
                RacingCar(name, movingStrategy = trueMovingStrategy)
            )
        )

        val expected = RacingCars.of(
            listOf(
                RacingCar(name, DistanceDriven(0), falseMovingStrategy),
                RacingCar(name, DistanceDriven(1), trueMovingStrategy)
            )
        )

        val movedRacingCars = racingCars.moveForward()
        assertThat(movedRacingCars).isEqualTo(expected)
    }

    @Test
    fun `현재 상태의 우승자를 반환한다`() {
        val falseMovingStrategy = MovingStrategy { false }
        val trueMovingStrategy = MovingStrategy { true }

        val firstCar = RacingCar(Name("first"), movingStrategy = falseMovingStrategy)
        val secondCar = RacingCar(Name("second"), movingStrategy = trueMovingStrategy)
        val thirdCar = RacingCar(Name("third"), movingStrategy = trueMovingStrategy)

        val racingCars = RacingCars.of(listOf(firstCar, secondCar, thirdCar))
        val movedRacingCars = racingCars.moveForward()
        val winningRacingCars: List<RacingCar> = movedRacingCars.winningRacingCars()

        assertAll(
            { assertThat(winningRacingCars).isNotNull },
            { assertThat(winningRacingCars.size).isEqualTo(2) },
            { assertThat(winningRacingCars).containsExactly(secondCar, thirdCar) },
        )
    }
}

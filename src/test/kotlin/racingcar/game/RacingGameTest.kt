package racingcar.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.car.Car
import racingcar.car.Position

internal class RacingGameTest : StringSpec({
    "자동차를 제공하지 않으면 에러가 발생한다" {
        val step = 10

        shouldThrow<IllegalArgumentException> {
            RacingGame(emptyList(), step)
        }
    }

    "round 에 음수를 넣으면 에러가 발생한다" {
        val stubCar = object : Car {
            override fun position(): Position = Position(1)
            override fun forward() = this
        }
        val cars = listOf(stubCar)
        val step = -1

        shouldThrow<IllegalArgumentException> {
            RacingGame(cars, step)
        }
    }

    "각 자동차에 대한 round 별 게임 결과를 반환한다" {
        // given
        class StubCar(private val position: Int, private val speed: Int) : Car {
            override fun position(): Position = Position(position)
            override fun forward(): Car = StubCar(position + speed, speed)
        }

        val cars = listOf(StubCar(0, 10), StubCar(0, 20))
        val step = 2
        val racingGame = RacingGame(cars, step)

        // when
        val results = racingGame.getResults()

        // then
        results.map { it.cars.map { car -> car.position().value } } shouldBe listOf(
            listOf(10, 20),
            listOf(20, 40)
        )
    }
})

package racingcar.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.car.RacingCar
import racingcar.engine.Distance
import racingcar.engine.Engine

internal class RacingGameTest : StringSpec({
    "자동차를 제공하지 않으면 에러가 발생한다" {
        val step = 10

        shouldThrow<IllegalArgumentException> {
            RacingGame(emptyList(), step)
        }
    }

    "round 에 음수를 넣으면 에러가 발생한다" {
        val stubEngine = object : Engine {
            override fun accelerate(): Distance = Distance(1)
        }
        val cars = List(1) { RacingCar(stubEngine) }
        val step = -1

        shouldThrow<IllegalArgumentException> {
            RacingGame(cars, step)
        }
    }

    "각 자동차에 대한 게임 결과를 반환한다" {
        // given
        val stubEngine = object : Engine {
            override fun accelerate(): Distance = Distance(1)
        }
        val cars = List(3) { RacingCar(stubEngine) }
        val step = 5
        val racingGame = RacingGame(cars, step)

        // when
        val result = racingGame.next()

        // then
        result.positions shouldHaveSize cars.size
        result.positions.forAll {
            it.value shouldBe 1
        }
    }

    "next 를 round 값 보다 많이 호출해도 최종 결과를 반환한다" {
        // given
        val distance = 10
        val stubEngine = object : Engine {
            override fun accelerate(): Distance = Distance(distance)
        }
        val cars = List(1) { RacingCar(stubEngine) }
        val step = 5
        val racingGame = RacingGame(cars, step)

        // when
        repeat(10) { racingGame.next() }

        // then
        val result = racingGame.next()
        result.positions.first().value shouldBe distance * step
    }
})

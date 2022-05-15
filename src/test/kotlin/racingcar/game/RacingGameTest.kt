package racingcar.game

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.car.RacingCar
import racingcar.engine.Distance
import racingcar.engine.Engine

internal class RacingGameTest : StringSpec({
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
})

package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingGame

class RacingGameTest : StringSpec({
    "게임 실행 후 자동차는 지정된 횟수만큼 움직여야 한다" {
        val carNames = listOf("car1", "car2")
        val attemptNumber = 5
        val racingGame = RacingGame(AlwaysMoveStrategy())

        val cars = racingGame.run(attemptNumber, carNames)

        cars.cars.forEach { car ->
            car.moveCount shouldBe  5
        }
    }
})

package racingcar

import io.kotest.core.spec.style.StringSpec

internal class RacingGameTest : StringSpec({
    "자동차 대수, 시도할 횟수가 주어지면 게임을 진행할 수 있다." {
        val numberOfCars = 3
        val numberOfTry = 5
        RacingGameController.play(numberOfCars, numberOfTry, RandomMoveStrategy())
    }
})

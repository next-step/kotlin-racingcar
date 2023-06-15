package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingGameTest : StringSpec({

    "자동가 수를 입력 받는다." {
        val carCount = 10
        val carRacingGame = CarRacingGame(carCount, 1) { -> true }
        carRacingGame.cars.size shouldBe carCount
    }

    "시도 횟수를 입력 받는다." {
        val round = 10
        val carRacingGame = CarRacingGame(10, round) { -> true }
        var roundCounter: Int = 0
        carRacingGame.race { roundCounter++ }
        roundCounter shouldBe round
    }

    "라운드가 실행될때 자동차는 이동할 수 있다." {
        val forceMoveStrategy = { -> true }
        val round = 10
        val carRacingGame = CarRacingGame(1, round, forceMoveStrategy)
        var roundCounter = 0
        carRacingGame.race { result ->
            roundCounter++
            result.cars.forEach {
                it.position shouldBe roundCounter
            }
        }
    }
})

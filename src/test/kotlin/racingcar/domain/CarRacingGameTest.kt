package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingGameTest : StringSpec({

    "자동가 수를 입력 받는다." {
        val carCount = 10
        val carRacingGame = CarRacingGame.of(carCount, 1) { -> true }
        carRacingGame.cars.size shouldBe carCount
    }

    "시도 횟수를 입력 받는다." {
        val round = 10
        val carRacingGame = CarRacingGame.of(10, round) { -> true }
        var roundCounter: Int = 0
        carRacingGame.race { roundCounter++ }
        roundCounter shouldBe round
    }

    "라운드가 실행될때 자동차는 이동할 수 있다." {

        val forceMoveStrategy = { -> true }
        val round = 10
        val carRacingGame = CarRacingGame.of(1, round, forceMoveStrategy)
        var roundCounter = 0

        val racingResult = carRacingGame.race { cars ->
            roundCounter++
            cars.forEach { it.position shouldBe roundCounter }
        }

        racingResult.cars.forEach {
            it.position shouldBe round
        }
    }

    "자동가 이름을 입력 받는다." {
        val carNames = listOf("제이든1", "제이든2", "제이든3", "제이든4")
        val carRacingGame = CarRacingGame(carNames, 1) { -> true }
        carRacingGame.cars.size shouldBe carNames.size
    }
})

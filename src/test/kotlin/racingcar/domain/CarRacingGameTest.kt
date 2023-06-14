package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class CarRacingGameTest : StringSpec({

    "자동가 수를 입력 받는다." {
        val carCount = 10
        val carRacingGame = CarRacingGame(carCount, 1) { -> true }
        carRacingGame.cars.size shouldBe carCount
    }

    "시도 횟수를 입력 받는다." {
        val round = 10
        val carRacingGame = CarRacingGame(10, round) { -> true }

        (1..round).forEach { _ ->
            carRacingGame.hasNextRound() shouldBe true
            carRacingGame.runRound()
        }

        carRacingGame.hasNextRound() shouldBe false
    }

    "시도 횟수를 초과할 수 없다." {
        val round = 5
        val carRacingGame = CarRacingGame(10, round) { -> true }

        (1..round).forEach { _ -> carRacingGame.runRound() }

        assertThrows<IllegalStateException> { carRacingGame.runRound() }
    }

    "라운드가 실행될때 자동차는 이동할 수 있다." {
        val forceMoveStrategy = { -> true }
        val round = 10
        val carRacingGame = CarRacingGame(1, round, forceMoveStrategy)
        (1..round).forEach { currentRound ->

            carRacingGame.runRound()

            carRacingGame.cars.forEach {
                it.position shouldBe currentRound
            }
        }
    }
})

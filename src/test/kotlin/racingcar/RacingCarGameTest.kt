package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarGame

class RacingCarGameTest : StringSpec({

    "입력 된 횟수만큼 Racing을 진행한다." {
        forAll(
            row(1, 0, true),
            row(1, 1, false),
        ) { numberOfAttempts, currentNumber, result ->
            val endRacingCarGame = RacingCarGame(listOf(RacingCar("race")), numberOfAttempts, currentNumber)
            endRacingCarGame.racingAttemptsCheck() shouldBe result
        }
    }

    "자동차 경주의 최종 우승자를 가져온다." {
        val racingCarGame = RacingCarGame(
            listOf(RacingCar("1등", 3), RacingCar("2등", 2)),
            3, 3)

        racingCarGame.winners() shouldBe "1등"
    }
})

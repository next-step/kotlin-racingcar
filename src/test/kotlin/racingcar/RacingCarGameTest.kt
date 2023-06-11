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
            val endRacingCarGame = RacingCarGame(listOf(RacingCar()), numberOfAttempts, currentNumber)
            endRacingCarGame.racingAttemptsCheck() shouldBe result
        }
    }
})

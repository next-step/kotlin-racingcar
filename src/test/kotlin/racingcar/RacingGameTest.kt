package racingcar

import io.kotest.core.spec.style.FunSpec

class RacingGameTest : FunSpec({
    context("RacingGame") {
        test("Test play") {
            val racingGame = RacingGame()
            racingGame.play()
        }
    }
})

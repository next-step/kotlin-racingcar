package step3

import io.kotest.core.spec.style.StringSpec

class RacingGameTest : StringSpec({

    "Racing Game Test" {
        val racingGame = RacingGame(3, 5)
        racingGame.racing()
    }
})

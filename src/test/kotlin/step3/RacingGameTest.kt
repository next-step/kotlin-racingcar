package step3

import io.kotest.core.spec.style.StringSpec

class RacingGameTest : StringSpec({

    "Racing Game Test" {
        val racingGame = RacingGame(
            GameSetting.builder()
                .inputCarCount(3)
                .inputMoveCount(5)
                .build()
        )
        racingGame.racing()
    }
})

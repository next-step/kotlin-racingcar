package step3.model

import io.kotest.core.spec.style.StringSpec
import step3.dto.GameSetting

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

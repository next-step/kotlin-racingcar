package step3.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import step3.dto.GameSetting

class RacingGameTest : StringSpec({

    "Racing Game Test" {
        val racingGame = RacingGame(
            GameSetting.Builder()
                .inputCarCount(3)
                .inputMoveCount(5)
                .build()
        )

        val result = racingGame.race()

        result shouldHaveSize 5
        result.forAll {
            it.moveResults shouldHaveSize 3
        }
    }
})

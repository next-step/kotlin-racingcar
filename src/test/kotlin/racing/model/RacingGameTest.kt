package racing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import racing.dto.GameSetting

class RacingGameTest : StringSpec({

    "Racing Game Test" {
        val racingGame = RacingGame(
            GameSetting.Builder()
                .inputCarNames(listOf("car1", "car2", "car3"))
                .inputMoveCount(5)
                .build()
        )

        racingGame.race()

        racingGame.record.trackResults shouldHaveSize 5
        racingGame.record.trackResults.forAll {
            it.moveResults shouldHaveSize 3
        }
    }
})

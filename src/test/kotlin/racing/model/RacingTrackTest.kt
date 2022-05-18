package racing.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racing.dto.GameSetting

class RacingTrackTest : FunSpec({

    test("move") {
        val gameSetting = GameSetting.Builder()
            .inputCarNames(listOf("car1", "car2", "car3"))
            .inputMoveCount(5)
            .build()
        val racingTrack = RacingTrack(gameSetting)

        val moveResults = racingTrack.move()

        moveResults.size shouldBe 3
    }
})

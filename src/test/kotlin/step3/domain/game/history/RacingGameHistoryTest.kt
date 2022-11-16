package step3.domain.game.history

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import step3.domain.game.RacingGame
import step3.domain.game.RacingGameDataSet

class RacingGameHistoryTest : FunSpec({
    lateinit var racingGame: RacingGame

    beforeEach {
        racingGame = RacingGameDataSet.testData()
    }

    test("RacingGameHistory 생성 정상 작동") {
        // Given
        racingGame.carList.size shouldBeGreaterThan 0

        // When
        val racingGameHistory = RacingGameHistory(racingGame)

        // Then
        racingGameHistory.racingCarHistoryList.size shouldBe racingGame.carList.size

        racingGameHistory.racingCarHistoryList.forEach { println(it) }
    }
})

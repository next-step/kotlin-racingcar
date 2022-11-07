package step3.domain.game.history

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import step3.domain.RacingGame
import step3.domain.RacingGameDataSet

class RacingGameHistoryTest : FunSpec({
    lateinit var racingGame: RacingGame

    beforeEach {
        racingGame = RacingGameDataSet.testData(true)
    }

    test("RacingGameHistory 생성 정상 작동") {
        // Given
        racingGame.isReadyToStart() shouldBe true
        racingGame.carList.size shouldBeGreaterThan 0

        // When
        val racingGameHistory = RacingGameHistory(racingGame)

        // Then
        racingGameHistory.history.size shouldBe racingGame.carList.size
        racingGameHistory.history.map { it.name }.containsAll(racingGame.carList.map { it.name }) shouldBe true
        println(racingGameHistory)
    }
})

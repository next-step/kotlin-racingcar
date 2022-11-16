package step3.domain.game

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows

class RacingGameTest : FunSpec({

    lateinit var racingGame: RacingGame

    beforeEach {
        racingGame = RacingGame()
    }

    test("RacingCar.nextStep() : 정상 작동") {
        // Given
        val beforeHistoryListSize = racingGame.historyList.size

        // When
        racingGame.nextStep()

        // Then
        racingGame.isCompleted() shouldBe (racingGame.historyList.size == racingGame.totalTryCount)

        val afterHistoryListSize = racingGame.historyList.size
        afterHistoryListSize shouldBe beforeHistoryListSize + 1
    }

    context("RacingCar.nextStep(Int) : 정상 작동") {
        table(
            headers("stepCount"),
            *(1..RacingGame.DEFAULT_TOTAL_TRY_COUNT).map { row(it) }.toTypedArray()
        ).forAll { stepCount ->
            test("stepCount: $stepCount") {
                // Given
                val beforeHistoryListSize = racingGame.historyList.size

                // When
                racingGame.nextStep(stepCount)

                // Then
                racingGame.isCompleted() shouldBe (stepCount == racingGame.totalTryCount)

                val afterHistoryListSize = racingGame.historyList.size
                afterHistoryListSize shouldBe beforeHistoryListSize + stepCount
            }
        }
    }

    context("RacingCar.nextStep(Int) : When invalid input parameter, IllegalArgumentException should be thrown") {
        table(
            headers("stepCount"),
            *((0 downTo -RacingGame.DEFAULT_TOTAL_TRY_COUNT) + (RacingGame.DEFAULT_TOTAL_TRY_COUNT + 1..3 * RacingGame.DEFAULT_TOTAL_TRY_COUNT)).map { row(it) }.toTypedArray()
        ).forAll { stepCount ->
            test("stepCount: $stepCount") {
                assertThrows<IllegalArgumentException> { racingGame.nextStep(stepCount) }
            }
        }
    }

    test("RacingCar.nextStepAll() : 정상 작동") {
        // When
        racingGame.nextStepAll()

        // Then
        racingGame.isCompleted() shouldBe true
        racingGame.historyList.size shouldBe racingGame.totalTryCount
    }

    test("RacingCar.addGameHistory() : OK") {
        // Given

        val beforeHistoryListSize = racingGame.historyList.size

        // When
        racingGame.nextStep()

        // Then
        val afterHistoryListSize = racingGame.historyList.size
        afterHistoryListSize shouldBe beforeHistoryListSize + 1
    }

    test("RacingCar.historyList : OK") {
        racingGame.historyList shouldNotBe null
    }

    test("RacingCar.isCompleted() : When completed, return true") {
        // Given
        racingGame.nextStepAll()

        // Expected
        racingGame.isCompleted() shouldBe true
    }

    context("RacingCar.isCompleted() : When not completed, return false") {
        table(
            headers("stepCount"),
            *(1 until RacingGame.DEFAULT_TOTAL_TRY_COUNT).map { row(it) }.toTypedArray()
        ).forAll { stepCount ->
            test("stepCount: $stepCount") {
                // Given
                racingGame.nextStep(stepCount)

                // Expected
                racingGame.isCompleted() shouldBe false
            }
        }
    }

    test("RacingCar.getWinnerRacingCarList() : 정상 작동") {
        // Given
        racingGame.nextStepAll()

        // When
        val winnerRacingCarList = racingGame.getWinnerRacingCarList()

        // Expected
        racingGame.isCompleted() shouldBe true
        winnerRacingCarList.size shouldBeGreaterThan 0
    }

    context("RacingCar.getWinnerRacingCarList() : When not completed, IllegalStateException should be thrown") {
        table(
            headers("stepCount"),
            *(1 until RacingGame.DEFAULT_TOTAL_TRY_COUNT).map { row(it) }.toTypedArray()
        ).forAll { stepCount ->
            test("stepCount: $stepCount") {
                // Given
                racingGame.nextStep(stepCount)

                // Expected
                assertThrows<IllegalStateException> { racingGame.getWinnerRacingCarList() }
            }
        }
    }
})

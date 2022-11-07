package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class RacingGameTest : FunSpec({

    lateinit var racingGame: RacingGame

    beforeEach {
        racingGame = RacingGame()
    }

    fun setReady(racingGame: RacingGame) {
        racingGame.addRacingCar("test1")
        racingGame.addRacingCar("test2")
        racingGame.addRacingCar("test3")
        racingGame.addRacingCar("test4")
        racingGame.addRacingCar("test5")

        racingGame.isReadyToStart() shouldBe true
    }

    test("RacingCar.nextStep() : When RacingGame is not ready, IllegalStateException should be thrown") {
        // Given
        racingGame.isReadyToStart() shouldBe false

        // Expected
        assertThrows<IllegalStateException> { racingGame.nextStep() }
    }

    context("RacingCar.nextStep(Int) : When RacingGame is not ready, IllegalStateException should be thrown") {
        table(
            headers("stepCount"),
            *(1..RacingGame.DEFAULT_TOTAL_TRY_COUNT).map { row(it) }.toTypedArray()
        ).forAll { stepCount ->
            test("stepCount: $stepCount") {
                // Given
                racingGame.isReadyToStart() shouldBe false

                // Expected
                assertThrows<IllegalStateException> { racingGame.nextStep(stepCount) }
            }
        }
    }

    test("RacingCar.nextStepAll() : When RacingGame is not ready, IllegalStateException should be thrown") {
        // Given
        racingGame.isReadyToStart() shouldBe false

        // Expected
        assertThrows<IllegalStateException> { racingGame.nextStepAll() }
    }

    test("RacingCar.nextStep() : 정상 작동") {
        // Given
        setReady(racingGame)
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
                setReady(racingGame)
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
                setReady(racingGame)
                assertThrows<IllegalArgumentException> { racingGame.nextStep(stepCount) }
            }
        }
    }

    test("RacingCar.nextStepAll() : 정상 작동") {
        // Given
        setReady(racingGame)

        // When
        racingGame.nextStepAll()

        // Then
        racingGame.isCompleted() shouldBe true
        racingGame.historyList.size shouldBe racingGame.totalTryCount
    }

    test("carList") { }

    test("RacingGame.addRacingCar(String) : 정상작동") {
        // Given
        val addCarName = "test1"
        val beforeCount = racingGame.carList.count { it.name == addCarName }

        // When
        racingGame.addRacingCar(addCarName)

        // Then
        val afterCount = racingGame.carList.count { it.name == addCarName }

        afterCount shouldBe beforeCount + 1
    }

    test("RacingCar.isFullRacingCar() : 정상 작동") {
        // Given
        setReady(racingGame)

        // Expected
        racingGame.isFullRacingCar() shouldBe true
    }

    context("RacingCar.isNotFullRacingCar() : 정상 작동") {
        table(
            headers("addCarCount"),
            *(0 until RacingGame.DEFAULT_TOTAL_TRY_COUNT).map { row(it) }.toTypedArray()
        ).forAll { addCarCount ->
            test("stepCount: $addCarCount") {
                // Given
                repeat(addCarCount) {
                    racingGame.addRacingCar("car$addCarCount")
                }

                // Expected
                racingGame.isNotFullRacingCar() shouldBe true
            }
        }
    }

    test("RacingCar.addGameHistory() : OK") {
        // Given
        setReady(racingGame)

        val beforeHistoryListSize = racingGame.historyList.size

        // When
        racingGame.addGameHistory()

        // Then
        val afterHistoryListSize = racingGame.historyList.size
        afterHistoryListSize shouldBe beforeHistoryListSize + 1
    }

    test("RacingCar.historyList : OK") {
        racingGame.historyList shouldNotBe null
    }

    test("RacingCar.isCompleted() : When completed, return true") {
        // Given
        setReady(racingGame)
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
                setReady(racingGame)
                racingGame.nextStep(stepCount)

                // Expected
                racingGame.isCompleted() shouldBe false
            }
        }
    }

    test("RacingCar.getWinnerRacingCarList() : 정상 작동") {
        // Given
        setReady(racingGame)
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
                setReady(racingGame)
                racingGame.nextStep(stepCount)

                // Expected
                assertThrows<IllegalStateException> { racingGame.getWinnerRacingCarList() }
            }
        }
    }
})

package step3.domain.game

import step3.domain.car.RacingCar
import step3.domain.car.container.RacingCarContainer
import step3.domain.game.history.RacingGameHistory
import step3.domain.game.history.RacingGameHistoryContainer
import step3.infra.random.DefaultRandomGenerator
import step3.infra.random.RandomGenerator

class RacingGame(
    carNameList: List<String>,
    val totalTryCount: Int,
) {

    companion object {
        const val DEFAULT_TOTAL_CAR_COUNT = 5
        const val DEFAULT_TOTAL_TRY_COUNT = 5
    }

    private val totalCarCount = carNameList.size

    private val racingCarContainer: RacingCarContainer = RacingCarContainer(totalCarCount)

    private val racingGameHistoryContainer = RacingGameHistoryContainer()

    private val randomGenerator: RandomGenerator<Int> = DefaultRandomGenerator

    private var currentTryCount = 0

    val carList: List<RacingCar>
        get() = racingCarContainer.carList

    val historyList: List<RacingGameHistory>
        get() = racingGameHistoryContainer.historyList

    init {
        require(totalCarCount > 0) { "Total Car Count must be positive number [$totalCarCount]" }
        require(totalTryCount > 0) { "Total Try Count must be positive number [$totalTryCount]" }

        carNameList.forEach { racingCarContainer.addRacingCar(it) }
    }

    fun nextStep() {
        checkReadyToStart()

        racingCarContainer.carList.forEach { if (randomGenerator.randomValid()) it.go() }

        currentTryCount++

        racingGameHistoryContainer.addGameHistory(this)
    }

    fun nextStep(stepCount: Int) {
        checkReadyToStart()

        require(stepCount in (1..totalTryCount - currentTryCount)) {
            "StepCount must be in [1..${totalTryCount - currentTryCount}]"
        }

        repeat(stepCount) {
            nextStep()
        }
    }

    fun nextStepAll() {
        checkReadyToStart()

        nextStep(totalTryCount - currentTryCount)
    }

    fun getWinnerRacingCarList(): List<RacingCar> {
        checkCompletedGame()

        return racingCarContainer.carList.filter {
            it.distance == racingCarContainer.carList.maxOf(RacingCar::distance)
        }
    }

    fun isCompleted() = currentTryCount == totalTryCount

    private fun isReadyToStart() = racingCarContainer.isFullRacingCar()

    private fun checkCompletedGame() =
        check(isCompleted()) { "Game is not completed [total: $totalTryCount, curr: $currentTryCount]" }

    private fun checkReadyToStart() =
        check(isReadyToStart()) { "Not ready to start [current racing car count: ${racingCarContainer.carList.size}]" }
}

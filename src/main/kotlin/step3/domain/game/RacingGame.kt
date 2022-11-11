package step3.domain

import step3.domain.car.RacingCar
import step3.domain.car.container.DefaultRacingCarContainer
import step3.domain.car.container.RacingCarContainer
import step3.domain.game.history.DefaultRacingGameHistoryContainer
import step3.domain.game.history.RacingGameHistoryContainer
import step3.infra.random.DefaultRandomGenerator
import step3.infra.random.RandomGenerator

class RacingGame(
    val totalCarCount: Int = DEFAULT_TOTAL_CAR_COUNT,
    val totalTryCount: Int = DEFAULT_TOTAL_TRY_COUNT,
    private val racingCarContainer: RacingCarContainer = DefaultRacingCarContainer(totalCarCount),
    private val racingGameHistoryContainer: RacingGameHistoryContainer = DefaultRacingGameHistoryContainer(),
    private val randomGenerator: RandomGenerator<Int> = DefaultRandomGenerator,
) : RacingCarContainer by racingCarContainer, RacingGameHistoryContainer by racingGameHistoryContainer {

    companion object {
        const val DEFAULT_TOTAL_CAR_COUNT = 5
        const val DEFAULT_TOTAL_TRY_COUNT = 5
    }

    private var currentTryCount = 0

    init {
        require(totalCarCount > 0) { "Total Car Count must be positive number [$totalCarCount]" }
        require(totalTryCount > 0) { "Total Try Count must be positive number [$totalTryCount]" }
    }

    fun nextStep() {
        checkReadyToStart()

        carList.forEach { if (randomGenerator.randomValid()) it.go() }
        currentTryCount++
        addGameHistory(this)
    }

    fun nextStep(stepCount: Int) {
        checkReadyToStart()

        require(stepCount in (1..totalTryCount - currentTryCount)) { "StepCount must be in [1..${totalTryCount - currentTryCount}]" }

        repeat(stepCount) {
            nextStep()
        }
    }

    fun nextStepAll() {
        checkReadyToStart()

        nextStep(totalTryCount - currentTryCount)
    }

    fun addGameHistory() = addGameHistory(this)

    fun getWinnerRacingCarList(): List<RacingCar> {
        checkCompletedGame()

        return carList.filter { it.distance == carList.maxOf { it.distance } }
    }

    fun isCompleted() = currentTryCount == totalTryCount

    fun isReadyToStart() = racingCarContainer.isFullRacingCar()

    fun isNotReadyToStart(): Boolean = !isReadyToStart()

    fun checkCompletedGame() =
        check(isCompleted()) { "Game is not completed [total: $totalTryCount, curr: $currentTryCount]" }

    fun checkReadyToStart() =
        check(isReadyToStart()) { "Not ready to start [current racing car count: ${racingCarContainer.carList.size}]" }
}

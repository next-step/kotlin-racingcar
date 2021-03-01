package racing.domain

import racing.data.RacingGameData
import racing.data.RacingHistory
import racing.data.RacingState

class RacingGame(private val racingGameData: RacingGameData, var movementChecker: MovementChecker) {

    val cars = mutableListOf<Car>()

    init {
        for (name in racingGameData.carNames) {
            cars.add(Car(name))
        }
    }

    fun run(): RacingHistory {
        val racingHistory = RacingHistory()
        repeat(racingGameData.tryCount) {
            moveAllCar()
            racingHistory.add(RacingState.of(cars))
        }
        return racingHistory
    }

    private fun moveAllCar() {
        cars.forEach { moveCarIfPossible(it) }
    }

    private fun moveCarIfPossible(car: Car) {
        if (movementChecker.isMovable()) {
            car.moveCar()
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    private fun getMaxPosition(): Int {
        val maxPosition = cars.maxBy { it.position }?.position
        return maxPosition ?: 0
    }
}

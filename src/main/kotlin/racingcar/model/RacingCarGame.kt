package racingcar.model

import racingcar.strategy.MovingStrategy

class RacingCarGame(
    val cars: List<Car>,
    private val strategy: MovingStrategy,
) {
    fun run(numbersOfTry: Int): List<RacingHistory> =
        List(numbersOfTry) { index -> RacingHistory(index, processOneStep()) }

    private fun processOneStep(): List<Car> {
        return cars.map {
            it.stepForward(strategy.canMove())
            it.copy()
        }
    }
}

package racingcar.model

import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomNumberMovingStrategy

class RacingCarGame(
    val cars: List<Car>,
    private val strategy: MovingStrategy = RandomNumberMovingStrategy(),
) {
    fun run(numbersOfTry: Int): GameResult =
        GameResult(List(numbersOfTry) { index -> RacingHistory(index, processOneStep()) })

    private fun processOneStep(): List<Car> {
        return cars.map {
            it.stepForward(strategy.canMove())
            it.copy()
        }
    }

    companion object {
        fun ofCarNames(namesOfCars: List<String>): RacingCarGame = RacingCarGame(Cars.create(namesOfCars))
    }
}

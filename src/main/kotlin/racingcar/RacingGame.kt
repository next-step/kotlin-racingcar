package racingcar

import racingcar.inputviews.GameInput
import racingcar.resultviews.GameResult
import racingcar.resultviews.RoundResult

class RacingGame(input: GameInput) {
    private val numberOfCars = input.numberOfCars
    private val numberOfRounds = input.numberOfRounds

    fun run(): GameResult {
        val cars = createCars(numberOfCars)
        val roundResults = (1..numberOfRounds).map { runRound(it, cars) }
        return GameResult(roundResults)
    }

    private fun createCars(numberOfCars: Int): List<Car> {
        return (1..numberOfCars).map { Car() }
    }

    private fun runRound(round: Int, cars: List<Car>): RoundResult {
        accelCars(cars)
        return RoundResult(round, cars.map { it.currentPosition })
    }

    private fun accelCars(cars: List<Car>) {
        for (car in cars) {
            car.accelerate(getFuel())
        }
    }

    private fun getFuel(): Int {
        return (MIN_FUEL..MAX_FUEL).random()
    }

    companion object {
        const val MIN_FUEL = 0
        const val MAX_FUEL = 9
    }
}

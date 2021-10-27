package racingcar

import racingcar.dtos.GameInput
import racingcar.dtos.GameResult
import racingcar.dtos.RoundResult

class RacingGame(input: GameInput) {
    private val carNames = input.carNames
    private val numberOfRounds = input.numberOfRounds

    fun run(): GameResult {
        val cars = createCars(carNames)
        val roundResults = (1..numberOfRounds).map { runRound(cars) }
        return GameResult(roundResults)
    }

    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    private fun runRound(cars: List<Car>): RoundResult {
        accelCars(cars)
        return RoundResult(cars.map { Car(it.name, it.position) })
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
        private const val MIN_FUEL = 0
        private const val MAX_FUEL = 9
    }
}

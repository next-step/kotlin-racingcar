package racingcar

import racingcar.fuelproviders.FuelProvider
import racingcar.inputviews.GameInput

data class GameResult(val cars: List<Car>)

class RacingGame(private val fuelProvider: FuelProvider) {
    fun run(input: GameInput): GameResult {
        val cars = initCars(input)
        for (round in 1..input.numberOfRounds) {
            accelCars(cars)
        }
        return GameResult(cars = cars)
    }

    private fun initCars(input: GameInput): List<Car> {
        return (1..input.numberOfCars).map { Car(it) }
    }

    private fun accelCars(cars: List<Car>) {
        for (car in cars) {
            val fuel = fuelProvider.getFuel()
            car.accelerate(fuel)
        }
    }
}

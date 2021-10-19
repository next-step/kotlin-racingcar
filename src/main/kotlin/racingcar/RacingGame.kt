package racingcar

import racingcar.fuelproviders.FuelProvider
import racingcar.fuelproviders.RandomFuelProvider
import racingcar.inputviews.GameInput
import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

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

fun main() {
    val inputView = RacingGameInputView()
    val resultView = RacingGameResultView()
    val game = RacingGame(RandomFuelProvider(0, 9))

    val input = inputView.receiveInput()

    val cars = game.run(input)

    resultView.printResult(cars)
}

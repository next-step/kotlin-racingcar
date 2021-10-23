package racingcar

import racingcar.fuelproviders.FuelProvider
import racingcar.inputviews.GameInput
import racingcar.inputviews.InputView
import racingcar.resultviews.ResultView

class RacingGame(
    private val fuelProvider: FuelProvider,
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun run() {
        val input = inputView.receiveInput()
        val cars = initCars(input)
        for (round in 1..input.numberOfRounds) {
            accelCars(cars)
            resultView.printResult(cars)
        }

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

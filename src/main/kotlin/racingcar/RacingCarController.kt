package racingcar

import racingcar.domain.Car
import racingcar.domain.Moving
import racingcar.domain.RandomNumberPicker
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val cars = createCars()
        val roundNumber = inputView.getRoundNumber() ?: DEFAULT_NUMBER

        outputView.printResultGuide()
        repeat(roundNumber) { playRound(cars) }
        outputView.printResult(cars)
    }

    private fun createCars(): List<Car> {
        val carNumber = inputView.getCarNumber() ?: DEFAULT_NUMBER
        return List(carNumber) { Car() }
    }

    private fun playRound(cars: List<Car>) {
        val randomNumberPicker = RandomNumberPicker()
        cars.forEach { car ->
            car.move(randomNumberPicker.getNumber())
        }
        outputView.printResult(cars)
    }

    companion object {
        private const val DEFAULT_NUMBER = 0
    }
}

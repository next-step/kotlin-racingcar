package racingcar

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.numberpicker.RandomNumberPicker
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val cars = createCars()
        val roundNumber = inputView.getRoundNumber() ?: DEFAULT_NUMBER

        outputView.printResultGuide()
        val randomNumberPicker = RandomNumberPicker()
        repeat(roundNumber) {
            cars.play(randomNumberPicker)
            outputView.printResult(cars)
        }
        outputView.printResult(cars)
    }

    private fun createCars(): Cars {
        val carNumber = inputView.getCarNumber() ?: DEFAULT_NUMBER
        return Cars(List(carNumber) { Car() })
    }

    companion object {
        private const val DEFAULT_NUMBER = 0
    }
}

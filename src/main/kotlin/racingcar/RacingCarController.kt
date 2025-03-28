package racingcar

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.numberpicker.RandomNumberPicker
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        var cars = createCars()
        val roundNumber = inputView.getRoundNumber() ?: DEFAULT_NUMBER

        outputView.printResultGuide()
        val randomNumberPicker = RandomNumberPicker()
        repeat(roundNumber) {
            cars = cars.play(randomNumberPicker)
            outputView.printResult(cars)
        }
        outputView.printResult(cars)

        val winners = cars.getWinners()
        outputView.printWinners(winners)
    }

    private fun createCars(): Cars {
        val names = inputView.getNames()
        return Cars(names.map { name -> Car(name) })
    }

    companion object {
        private const val DEFAULT_NUMBER = 0
    }
}

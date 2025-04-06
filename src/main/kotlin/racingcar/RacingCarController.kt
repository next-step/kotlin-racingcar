package racingcar

import racingcar.domain.car.Cars
import racingcar.domain.numberpicker.RandomNumberPicker
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        var cars = Cars.from(inputView.getNames())
        val roundNumber = inputView.getRoundNumber() ?: DEFAULT_NUMBER

        outputView.printResultGuide()
        val randomNumberPicker = RandomNumberPicker()
        repeat(roundNumber) {
            cars = cars.play(randomNumberPicker)
            outputView.printResult(cars)
        }
        outputView.printResult(cars)

        val winners = cars.getWinners
        outputView.printWinners(winners)
    }

    companion object {
        private const val DEFAULT_NUMBER = 0
    }
}

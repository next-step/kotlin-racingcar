package racingcar

import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val carNumber = inputView.getCarNumber() ?: 0
        val roundNumber = inputView.getRoundNumber() ?: 0

        val cars = List(carNumber) { Car() }

        repeat(roundNumber) {
            cars.forEach { car ->
                car.move(getRandomNumber())
            }
            outputView.printResult(cars)
        }

        outputView.printResult(cars)
    }

    private fun getRandomNumber(): Int {
        return (0..9).random()
    }
}

package racingcar

import racingcar.domain.Car
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
        cars.forEach { car ->
            car.move(getRandomNumber())
        }
        outputView.printResult(cars)
    }

    private fun getRandomNumber(): Int {
        return (MINIMUM_VALUE..MAXIMUM_VALUE).random()
    }

    companion object {
        private const val DEFAULT_NUMBER = 0
        private const val MINIMUM_VALUE = 0
        private const val MAXIMUM_VALUE = 9
    }
}

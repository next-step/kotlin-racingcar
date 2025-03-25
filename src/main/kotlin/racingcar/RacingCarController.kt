package racingcar

import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val cars = createCars()
        val roundNumber = inputView.getRoundNumber() ?: 0

        repeat(roundNumber) { playRound(cars) }

        outputView.printResult(cars)
    }

    private fun createCars(): List<Car> {
        val carNumber = inputView.getCarNumber() ?: 0
        return List(carNumber) { Car() }
    }

    private fun playRound(cars: List<Car>) {
        cars.forEach { car ->
            car.move(getRandomNumber())
        }
        outputView.printResult(cars)
    }

    private fun getRandomNumber(): Int {
        return (0..9).random()
    }
}

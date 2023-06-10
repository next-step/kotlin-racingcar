package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.RandomCondition
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarService {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val numberOfCars = inputView.numberOfCar()
        val cars = Cars(numberOfCars)
        val numberOfAttempts = inputView.numberOfAttempts()

        outputView.printResult()
        repeat(numberOfAttempts) {
            cars.attempt(RandomCondition())
            cars.positions.forEach { position ->
                outputView.printPosition(position)
            }
            println()
        }
    }
}

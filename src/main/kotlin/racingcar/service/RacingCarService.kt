package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.RandomCondition
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarService {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val namesOfCars = inputView.namesOfCars()
        val cars = Cars(namesOfCars)
        val numberOfAttempts = inputView.numberOfAttempts()

        outputView.printResult()
        repeat(numberOfAttempts) {
            cars.attempt(RandomCondition())
            cars.carList.forEach { car ->
                outputView.printCarPosition(car)
            }
            println()
        }

        outputView.printWinners(cars)
    }
}

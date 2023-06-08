package racingcar.controller

import racingcar.view.InputView

class RacingCarController {

    private val inputView: InputView = InputView()

    fun start() {
        val countOfCars = inputView.enterCountOfCars()
        val numberOfAttempts = inputView.enterNumberOfAttempts()

        println(countOfCars)
        println(numberOfAttempts)
    }
}

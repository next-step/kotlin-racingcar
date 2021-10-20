package step3.domain

import step3.view.InputView
import step3.view.ResultView

class CarRacing(private val inputView: InputView = InputView(), private val resultView: ResultView = ResultView()) {

    fun start() {

        val carCount = inputView.inputNumberOfCars()
        val racingCount = inputView.inputNumberOfAttempts()

        val carList = CarFactory(carCount).carList

        for (i in 0 until racingCount) {
            for (car in carList) {
                car.forward()
            }
            resultView.action(carList)
            println()
        }
    }
}

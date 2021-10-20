package step3.domain

import step3.view.InputView

class CarRacing(private val inputView: InputView = InputView()) {

    fun start() {

        val carCount = inputView.inputNumberOfCars()
        val racingCount = inputView.inputNumberOfAttempts()

        val carList = CarFactory(carCount).carList

        for (i in 0..racingCount) {
            for (car in carList) {
                car.forward()
            }
        }
    }
}

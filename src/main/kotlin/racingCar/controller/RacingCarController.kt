package racingCar.controller

import racingCar.domain.Car
import racingCar.domain.service.MoveStrategy
import racingCar.domain.serviceImpl.RandomStrategy
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    OutputView.printCarCount()
    val carCount = InputView.inputNumber()
    OutputView.printTryCount()
    val tryCount = InputView.inputNumber()
    OutputView.printExecuteResult()

    var cars: List<String> = ArrayList()

    val moveStrategy: MoveStrategy = RandomStrategy()

    for (i in 0 until carCount) {
        if (moveStrategy.isMove()) {
            val car = Car()
            car.moveCar()
        }
    }
}

package racingCar.controller

import racingCar.domain.Cars
import racingCar.domain.Car
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    OutputView.printCarCount()
    val carCount = InputView.inputNumber()
    OutputView.printTryCount()
    val tryCount = InputView.inputNumber()
    OutputView.printExecuteResult()

    // List factory 함수 사용
    val carList: List<Car> = List(carCount) { Car() }

    val cars = Cars()
    cars.moveCar(carList, tryCount)
}

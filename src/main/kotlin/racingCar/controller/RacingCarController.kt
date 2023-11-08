package racingCar.controller

import racingCar.domain.Cars
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    OutputView.printCarName()
    val inputCars = InputView.inputCars()
    OutputView.printTryCount()
    val tryCount = InputView.inputNumber()
    OutputView.printExecuteResult()

    val cars = Cars()
    cars.initCars(inputCars)
    cars.carsMove(tryCount)
    OutputView.printCar(cars.carHisList)
    OutputView.printWinner(cars)
}

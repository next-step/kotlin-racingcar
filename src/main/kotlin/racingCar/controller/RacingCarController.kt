package racingCar.controller

import racingCar.domain.Cars
import racingCar.domain.Car
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    OutputView.printCarName()
    val inputCars = InputView.inputCars()
    OutputView.printTryCount()
    val tryCount = InputView.inputNumber()
    OutputView.printExecuteResult()

    val cars = Cars()
    val carList: List<Car> = cars.getCars(inputCars)
    cars.moveCar(carList, tryCount)
    OutputView.printWinner(carList)
}

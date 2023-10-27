package racingCar.controller

import racingCar.domain.Cars
import racingCar.domain.Car
import racingCar.view.InputView
import racingCar.view.OutputView
import java.util.Arrays

fun main() {
    OutputView.printCarCount()
    val carCount = InputView.inputNumber()
    OutputView.printTryCount()
    val tryCount = InputView.inputNumber()
    OutputView.printExecuteResult()

    // carList 초기화
    val carList: MutableList<Car> = ArrayList()
    for (i in 0 until carCount) {
        val car = Car()
        carList.add(car)
    }

    val cars = Cars()
    for (i in 0 until tryCount) {
        cars.moveCar(carList)
        OutputView.printCar(carList)
    }
}

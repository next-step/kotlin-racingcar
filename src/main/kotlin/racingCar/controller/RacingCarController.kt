package racingCar.controller

import racingCar.domain.Car
import racingCar.domain.Cars
import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    OutputView.printCarName()
    val inputCars = InputView.inputCars()
    OutputView.printTryCount()
    val tryCount = InputView.inputNumber()
    OutputView.printExecuteResult()

    val moveStrategy: MoveStrategy = RandomStrategy()
    val cars = Cars(moveStrategy)
    val carList: List<Car> = cars.getCars(inputCars)
    repeat(tryCount) {
        carList.forEach { it.move() }
        OutputView.printCar(carList)
    }
    OutputView.printWinner(carList)
}

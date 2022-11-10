package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val nameOfCars = inputView.getNameOfCars()
    val tryCount = inputView.getTryCount()

    val cars = Cars(List(nameOfCars.size) { Car() })
    repeat(tryCount) {
        cars.race()
        resultView.printCarDistance(cars)
    }
}

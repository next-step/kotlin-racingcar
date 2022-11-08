package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carCount = inputView.getCarCount()
    val tryCount = inputView.getTryCount()

    val cars = Cars(List(carCount) { Car() })
    repeat(tryCount) {
        cars.race()
        resultView.printCarDistance(cars)
    }
}

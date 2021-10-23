package racingcar.resultviews

import racingcar.Car

interface ResultView {
    fun printResult(cars: List<Car>)
}

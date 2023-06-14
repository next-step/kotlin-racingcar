package study.racing.resultview

import study.racing.car.Car

interface ResultView {
    fun printResult(cars: List<Car>)
}

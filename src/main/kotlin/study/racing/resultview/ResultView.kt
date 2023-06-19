package study.racing.resultview

import study.racing.car.Car

interface ResultView {
    fun printMessage()
    fun printRoundResult(cars: List<Car>)
    fun printWinners(cars: List<Car>)
}

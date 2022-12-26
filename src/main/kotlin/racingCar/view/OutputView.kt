package view

import racingCar.Entity.Car

class OutputView {
    fun printResultMsg() {
        println("실행 결과")
    }

    fun printCars(cars: List<Car>) {
        cars.forEach { println(it.distance) }
        println()
    }
}

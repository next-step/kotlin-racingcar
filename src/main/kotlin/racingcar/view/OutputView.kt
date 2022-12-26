package view

import racingcar.entity.Car

class OutputView {
    fun printResultMsg() {
        println("실행 결과")
    }

    fun printCars(cars: List<Car>) {
        cars.forEach { println(it.distance) }
        println()
    }
}

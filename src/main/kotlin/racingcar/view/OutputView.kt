package view

import racingcar.entity.Car

class OutputView {
    fun printResultMsg() {
        println("실행 결과")
    }

    fun printCars(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${it.distance}") }
        println()
    }

    fun printWiningCars(cars: List<Car>) {
        val winingCars = cars.joinToString(",") { it.name }
        println("${winingCars}가 최종 우승했습니다.")
    }
}

package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.Cars

object ResultView {

    fun printResult(cars: Cars, count: Int) {
        println("실핼결과")
        printSpacer()

        var result = cars
        repeat(count) {
            result = result.racing()
            printCarsPosition(result)
            printSpacer()
        }
    }

    private fun printCarsPosition(cars: Cars) {
        cars.value.forEach { car ->
            printCarState(car)
            printSpacer()
        }
    }

    private fun printCarState(car: Car) {
        repeat(car.position.value) {
            print("-")
        }
    }

    private fun printSpacer() = println()

}
package racingcar.view

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class ResultView {
    companion object {
        fun printResult(cars: Cars) {
            cars.cars.forEach { printCar(it) }
            println()
        }

        private fun printCar(car: Car) {
            println("${car.name.value} : ${"-".repeat(car.position.value)}")
        }

        fun printResultTitle() {
            println("\n" + "실행 결과")
        }
    }
}

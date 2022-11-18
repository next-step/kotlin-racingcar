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

        fun printWinners(winners: List<String>) {
            println("${winners.joinToString(", ")}가 최종 우승했습니다.")
        }
    }
}

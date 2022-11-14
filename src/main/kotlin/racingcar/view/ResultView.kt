package racingcar.view

import racingcar.domain.car.Cars

class ResultView {
    companion object {
        fun printResult(cars: Cars) {
            cars.getPositions().forEach { printCar(it.position) }
            println()
        }

        private fun printCar(position: Int) {
            repeat(position) { print("-") }
            println()
        }

        fun printResultTitle() {
            println("\n" + "실행 결과")
        }
    }
}

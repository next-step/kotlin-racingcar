package step3.view

import step3.domain.car.Cars

class ResultView {
    companion object {
        fun printResult(cars: Cars) {
            cars.getPositions().forEach { printCar(it.getPosition()) }
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

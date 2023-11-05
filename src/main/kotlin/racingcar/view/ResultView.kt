package racingcar.view

import racingcar.domain.Car

class ResultView {

    companion object {
        fun printResultInit() {
            println("실행 결과")
        }

        fun printResult(cars: List<Car>) {
            cars.forEach { car: Car ->
                printPosition(car)
                println()
            }
            println()
        }

        private fun printPosition(car: Car) {
            for (j in 0 until car.position step 1) {
                print("-")
            }
        }
    }
}

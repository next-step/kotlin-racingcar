package race.ui

import race.domain.Car

class ResultView {

    companion object {
        fun printTitle() {
            println("실행 결과")
        }

        fun printNow(cars: List<Car>) {
            cars.forEach {
                IntRange(1, it.position).forEach { _ -> print("-") }
                println("")
            }
        }
    }
}

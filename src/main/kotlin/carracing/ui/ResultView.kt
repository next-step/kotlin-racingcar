package carracing.ui

import carracing.domain.Car

object ResultView {
    fun printCurrentPosition(cars: List<Car>) {
        cars.forEach { car ->
            println("-".repeat(car.position))
        }
        println()
    }

    fun printStartMessage() {
        println("\n실행 결과")
    }
}

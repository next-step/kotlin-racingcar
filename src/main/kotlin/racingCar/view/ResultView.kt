package racingCar.view

import racingCar.domain.Car

object ResultView {
    private const val PRINT_SYMBOL = "-"
    fun printStart() {
        println("실행 결과")
    }

    fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            printPosition(car.position)
        }
        println()
    }

    fun printPosition(position: Int) {
        repeat(position) { print(PRINT_SYMBOL) }
        println()
    }
}


package racingcar.view

import racingcar.model.Car
import racingcar.service.CarGame

private const val TRACE_SYMBOL = "-"

object ResultView {
    fun printHeader() {
        println("\n실행결과")
    }

    fun printDashBoard(carGame: CarGame) {
        val cars = carGame.cars
        cars.forEach { printCarTrace(it) }
        println()
    }

    private fun printCarTrace(car: Car) {
        repeat(car.position.value) {
            print(TRACE_SYMBOL)
        }
        println()
    }
}

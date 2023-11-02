package game.racing.view

import game.racing.domain.Car

object ResultView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val POSITION_DELIMITER = "-"

    fun printResultIntroduction() {
        println(RESULT_MESSAGE)
    }

    private fun printCarPosition(car: Car) {
        if (car.position == Car.MIN_POSITION) {
            return
        }
        println(POSITION_DELIMITER.repeat(car.position))
    }

    fun printResult(cars: List<Car>) {
        cars.forEach {
            printCarPosition(it)
        }
        println()
    }
}

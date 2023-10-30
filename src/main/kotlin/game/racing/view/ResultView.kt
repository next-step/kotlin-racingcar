package game.racing.view

import game.racing.domain.Car

object ResultView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val POSITION_DELIMITER = "-"

    fun printResult(cars: List<Car>) {
        println(RESULT_MESSAGE)
        cars.forEach {
            println(POSITION_DELIMITER.repeat(it.position))
        }
    }
}

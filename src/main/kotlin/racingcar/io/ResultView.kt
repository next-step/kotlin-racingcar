package racingcar.io

import racingcar.domain.Car
import racingcar.domain.Cars

object ResultView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val MOVE_MARK = "-"

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printRound(cars: Cars) {
        for (car in cars) {
            printRow(car)
        }
        println()
    }

    private fun printRow(car: Car) {
        println("${car.name} : ${MOVE_MARK.repeat(car.getPosition())}")
    }
}

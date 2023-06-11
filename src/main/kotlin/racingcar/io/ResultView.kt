package racingcar.io

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Input
import racingcar.racing.Racing

class ResultView {

    fun printGame(input: Input) {
        println(RESULT_MESSAGE)

        val racing = Racing(input, printResult = ::printRound)
        racing.start()
    }

    private fun printRound(cars: Cars) {
        for (car in cars) {
            printRow(car)
        }
        println()
    }

    private fun printRow(car: Car) {
        println(MOVE_MARK.repeat(car.getPosition()))
    }

    companion object {
        private const val RESULT_MESSAGE = "실행 결과"
        private const val MOVE_MARK = "-"
    }
}

package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

object OutputView {

    private const val RESULT_MESSAGE = "실행 결과"
    private const val CAR_TRACK = "-"

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printQuestionCarNumber() {
        println("자동차 대수는 몇 대 인가요?")
    }

    fun printQuestionTryCount() {
        println("시도할 회수는 몇회인가요?")
    }

    fun printResultTitle(cars: Cars) {
        println("실행 결과")
    }

    fun printResult(result: List<Car>) {
        result.forEach {
            println(CAR_TRACK.repeat(it.getPosition().toInt()))
        }
        println()
    }
}

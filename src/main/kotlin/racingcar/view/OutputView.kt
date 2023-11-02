package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

object OutputView {

    private const val RESULT_MESSAGE = "실행 결과"
    private const val CAR_TRACK = "-"

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printQuestionCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
    }

    fun printQuestionTryCount() {
        println("시도할 회수는 몇회인가요?")
    }

    fun printResultTitle(cars: Cars) {
        println("실행 결과")
    }

    fun printResult(result: List<Car>) {
        result.forEach {
            println(CAR_TRACK.repeat(it.position.toInt()))
        }
        println()
    }
}

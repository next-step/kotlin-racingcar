package racingcar.view

import racingcar.model.Car
import racingcar.model.RoundResults

object OutputView {

    private const val RESULT_MESSAGE = "실행 결과"
    private const val CAR_TRACK = "-"

    fun printQuestionCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
    }

    fun printQuestionTryCount() {
        println("시도할 회수는 몇회인가요?")
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.carName.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    fun printRoundResult(roundResults: List<RoundResults.RoundResult>) {
        println(RESULT_MESSAGE)

        roundResults.forEach { result ->
            printResultByRound(result)
            print(System.lineSeparator())
        }
    }

    private fun printResultByRound(result: RoundResults.RoundResult) {
        result.results.forEach {
            val moveResult = CAR_TRACK.repeat(it.position.toInt())
            println("${it.name} : $moveResult")
        }
    }
}

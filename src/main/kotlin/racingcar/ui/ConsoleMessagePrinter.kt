package racingcar.ui

import racingcar.application.MessagePrinter
import racingcar.application.RaceResults
import racingcar.application.Winners

object ConsoleMessagePrinter : MessagePrinter {
    private const val CAR_COUNT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val MOVE_ATTEMPT_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?"
    private const val RESULT_MESSAGE = "실행 결과"

    override fun printCarNameQuestion() {
        println(CAR_COUNT_QUESTION)
    }

    override fun printMoveAttemptCountQuestion() {
        println(MOVE_ATTEMPT_COUNT_QUESTION)
    }

    override fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    override fun printRaceResultMessage(raceResults: RaceResults) {
        val raceResult = RaceResultGenerator.generate(raceResults)
        println(raceResult)
    }

    override fun printWinners(winners: Winners) {
        val winnerMessage = WinnerMessageGenerator.generate(winners)
        println(winnerMessage)
    }
}

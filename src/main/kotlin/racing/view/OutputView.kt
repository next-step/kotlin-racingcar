package racing.view

import racing.model.RacingHistory

class OutputView {

    fun printResults(racingHistory: RacingHistory) {
        println("실행 결과")
        for (history in racingHistory.roundHistories) {
            println(ConsoleRender.consolePresent(history) + "\n")
        }
    }
}

package racing.view

import racing.model.RacingHistory

class OutputView {

    fun printRacingHistory(racingHistory: RacingHistory) {
        println("실행 결과")
        for (roundHistory in racingHistory.roundHistories) {
            println(ConsoleRender.roundRendering(roundHistory) + "\n")
        }
    }
}

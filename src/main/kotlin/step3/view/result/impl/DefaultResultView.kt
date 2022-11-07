package step3.view.result.impl

import step3.domain.RacingGame

class DefaultResultView : AbstractResultView() {

    override fun printRacingGameResult(racingGame: RacingGame) {
        check(racingGame.isCompleted()) { "RacingGame is not completed" }

        println("실행 결과")

        racingGame.historyList.forEach {
            printRacingGameHistory(it)
        }

        printWinnerRacingCarList(racingGame)
    }
}

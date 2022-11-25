package step3.view.result

import step3.domain.game.RacingGame
import step3.view.result.history.RacingGameHistoryView
import step3.view.result.winner.RacingGameWinnerView

class ResultView(
    private val racingGameHistoryView: RacingGameHistoryView,
    private val racingGameWinnerView: RacingGameWinnerView
) {

    fun printRacingGameResult(racingGame: RacingGame) {
        println("실행 결과")

        racingGame.historyList.forEach {
            racingGameHistoryView.printRacingGameHistory(it)
        }

        racingGameWinnerView.printRacingGameWinner(racingGame)
    }
}

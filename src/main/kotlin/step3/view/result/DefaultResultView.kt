package step3.view.result

import step3.domain.RacingGame
import step3.view.result.history.DefaultRacingGameHistoryView
import step3.view.result.history.RacingGameHistoryView
import step3.view.result.winner.DefaultWinnerRacingCarListView
import step3.view.result.winner.WinnerRacingCarListView

class DefaultResultView(
    private val racingGameHistoryView: RacingGameHistoryView = DefaultRacingGameHistoryView(),
    private val winnerRacingCarList: WinnerRacingCarListView = DefaultWinnerRacingCarListView()
) : ResultView, RacingGameHistoryView by racingGameHistoryView, WinnerRacingCarListView by winnerRacingCarList {

    override fun printRacingGameResult(racingGame: RacingGame) {
        check(racingGame.isCompleted()) { "RacingGame is not completed" }

        println("실행 결과")

        racingGame.historyList.forEach {
            printRacingGameHistory(it)
        }

        printWinnerRacingCarList(racingGame)
    }
}

package step3.view.result

import step3.domain.RacingGame
import step3.view.result.history.RacingGameHistoryView
import step3.view.result.winner.WinnerRacingCarListView

interface ResultView : RacingGameHistoryView, WinnerRacingCarListView {
    fun printRacingGameResult(racingGame: RacingGame)
}

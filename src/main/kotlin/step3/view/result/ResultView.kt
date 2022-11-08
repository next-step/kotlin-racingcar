package step3.view.result

import step3.domain.RacingGame

interface ResultView : RacingGameHistoryView, WinnerRacingCarListView {

    fun printRacingGameResult(racingGame: RacingGame)
}

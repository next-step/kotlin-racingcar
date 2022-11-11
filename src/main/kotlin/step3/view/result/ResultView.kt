package step3.view.result

import step3.domain.RacingGame
import step3.view.result.history.RacingGameHistoryView

interface ResultView : RacingGameHistoryView {

    fun printRacingGameResult(racingGame: RacingGame)
}

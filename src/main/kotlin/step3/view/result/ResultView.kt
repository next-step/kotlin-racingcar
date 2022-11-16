package step3.view.result

import step3.domain.game.RacingGame
import step3.view.result.history.RacingGameHistoryView

interface ResultView : RacingGameHistoryView {

    fun printRacingGameResult(racingGame: RacingGame)
}

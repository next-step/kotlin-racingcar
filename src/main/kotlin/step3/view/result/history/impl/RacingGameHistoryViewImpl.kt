package step3.view.result.history.impl

import step3.domain.game.history.RacingCarHistory
import step3.view.result.history.RacingGameHistoryView

class RacingGameHistoryViewImpl : RacingGameHistoryView {

    override fun printRacingCarHistory(racingCarHistory: RacingCarHistory) {
        repeat(racingCarHistory.distance) {
            print("-")
        }
        println()
    }
}

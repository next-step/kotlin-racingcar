package step3.view.result.history.impl

import step3.domain.game.history.RacingCarHistory
import step3.view.result.history.RacingGameHistoryView

class RacingGameHistoryWithCarNameViewImpl : RacingGameHistoryView {

    override fun printRacingCarHistory(racingCarHistory: RacingCarHistory) {
        print("${racingCarHistory.carName.name} : ")
        repeat(racingCarHistory.carDistance.distance) {
            print("-")
        }
        println()
    }
}

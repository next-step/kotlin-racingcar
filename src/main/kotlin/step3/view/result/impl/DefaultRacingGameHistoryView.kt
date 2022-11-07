package step3.view.result.impl

import step3.domain.game.history.RacingCarHistory
import step3.domain.game.history.RacingGameHistory
import step3.view.result.RacingGameHistoryView

class DefaultRacingGameHistoryView : RacingGameHistoryView {
    override fun printRacingGameHistory(racingGameHistory: RacingGameHistory) {
        racingGameHistory.racingCarHistoryList.forEach { printRacingCarHistory(it) }
        println()
    }

    override fun printRacingCarHistory(racingCarHistory: RacingCarHistory) {
        print("${racingCarHistory.name} : ")
        repeat(racingCarHistory.distance) {
            print("-")
        }
        println()
    }
}

package step3.view.result.history

import step3.domain.game.history.RacingCarHistory
import step3.domain.game.history.RacingGameHistory

interface RacingGameHistoryView {

    fun printRacingGameHistory(racingGameHistory: RacingGameHistory) {
        racingGameHistory.racingCarHistoryList.forEach { printRacingCarHistory(it) }
        println()
    }

    fun printRacingCarHistory(racingCarHistory: RacingCarHistory)
}

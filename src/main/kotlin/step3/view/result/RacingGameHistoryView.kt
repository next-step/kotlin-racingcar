package step3.view.result

import step3.domain.game.history.RacingCarHistory
import step3.domain.game.history.RacingGameHistory

interface RacingGameHistoryView {
    fun printRacingGameHistory(racingGameHistory: RacingGameHistory)

    fun printRacingCarHistory(racingCarHistory: RacingCarHistory)
}

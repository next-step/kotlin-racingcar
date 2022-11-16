package step3.domain.game.history

import step3.domain.game.RacingGame

class RacingGameHistoryContainer {

    val historyList: List<RacingGameHistory> = mutableListOf()

    fun addGameHistory(racingGame: RacingGame) {
        (historyList as MutableList).add(RacingGameHistory(racingGame))
    }
}

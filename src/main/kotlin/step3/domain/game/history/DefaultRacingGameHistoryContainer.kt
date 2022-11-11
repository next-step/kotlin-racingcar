package step3.domain.game.history

import step3.domain.RacingGame

class DefaultRacingGameHistoryContainer : RacingGameHistoryContainer {

    override val historyList: List<RacingGameHistory> = mutableListOf()

    override fun addGameHistory(racingGame: RacingGame) {
        (historyList as MutableList).add(RacingGameHistory(racingGame))
    }
}

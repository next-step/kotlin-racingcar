package step3.domain.game.history

import step3.domain.RacingGame

class DefaultRacingGameHistoryContainer : RacingGameHistoryContainer {
    override var historyList: MutableList<RacingGameHistory> = mutableListOf()

    override fun addGameHistory(racingGame: RacingGame) {
        historyList.add(RacingGameHistory(racingGame))
    }

    // fun getGameHistory(step: Int) = historyList[step]
    //
    // fun printGameHistory() {
    //     historyList.forEach{ println(it) }
    // }
}

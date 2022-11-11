package step3.domain.game.history

import step3.domain.RacingGame

interface RacingGameHistoryContainer {

    val historyList: List<RacingGameHistory>

    fun addGameHistory(racingGame: RacingGame)
}

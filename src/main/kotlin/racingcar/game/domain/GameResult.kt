package racingcar.game.domain

import racingcar.game.vo.GameRoundResult

class GameResult {
    val history: List<GameRoundResult> = mutableListOf()

    fun recordGameRoundHistory(gameRoundResult: GameRoundResult) {
        history as MutableList
        history.add(gameRoundResult)
    }
}

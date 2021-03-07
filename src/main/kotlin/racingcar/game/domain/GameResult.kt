package racingcar.game.domain

import racingcar.game.vo.GameRoundResult

class GameResult {
    private val _history = mutableListOf<GameRoundResult>()
    val history: List<GameRoundResult>
        get() = _history.toList()

    fun recordGameRoundHistory(gameRoundResult: GameRoundResult) {
        _history.add(gameRoundResult)
    }
}

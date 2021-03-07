package racingcar.game.domain

import racingcar.game.vo.GameResult
import racingcar.game.vo.GameRoundResult

class Dashboard {
    val gameResult: GameResult = GameResult(mutableListOf())

    fun recordGameRoundHistory(gameRoundResult: GameRoundResult) {
        gameResult.history.add(gameRoundResult)
    }
}

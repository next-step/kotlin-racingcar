package racingcar.game.ui

import racingcar.game.vo.GameResult
import racingcar.game.vo.GameRoundResult
import racingcar.game.vo.Position

object Screen {
    fun show(result: GameResult) {
        result.history.forEach { roundResult ->
            showRoundGame(roundResult)
        }
    }

    private fun showRoundGame(roundResult: GameRoundResult) {
        roundResult.roundHistory.forEach { position ->
            printResult(position)
        }
    }

    private fun printResult(pos: Position) {
        println("-".repeat(pos.num))
    }
}

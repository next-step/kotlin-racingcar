package racingcar.domain

import racingcar.data.CarMoves

class MoveHistory(val moveHistory: List<CarMoves>) {
    fun getWinningCarNames(): List<String> {
        val maxMoveCount = moveHistory.maxOfOrNull { it.moves[it.moves.size - 1] } ?: 0

        return moveHistory.filter {
            it.moves[it.moves.size - 1] == maxMoveCount
        }.map { it.carName }
    }
}

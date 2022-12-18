package racingcar.domain

class MoveHistory {
    val moveHistory: Map<String, MutableList<Int>> = LinkedHashMap()

    fun addMove(moveInfo: MoveInfo) {
        val carMoves = moveHistory[moveInfo.carName] ?: mutableListOf<Int>().apply {
            (moveHistory as LinkedHashMap)[moveInfo.carName] = this
        }

        carMoves.add(moveInfo.moveCount)
    }

    fun getWinningCarNames(): List<String> {
        val maxMoveCount = moveHistory.values.maxOfOrNull {
            it[it.size - 1]
        } ?: 0

        return moveHistory.entries.filter {
            it.value[it.value.size - 1] == maxMoveCount
        }.map { it.key }
    }
}

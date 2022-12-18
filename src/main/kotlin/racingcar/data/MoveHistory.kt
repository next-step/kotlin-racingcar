package racingcar.data

class MoveHistory {
    val moveHistory = LinkedHashMap<String, MutableList<Int>>()

    fun addMove(moveInfo: MoveInfo) {
        val carMoves = moveHistory[moveInfo.carName] ?: mutableListOf<Int>().apply {
            moveHistory[moveInfo.carName] = this
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

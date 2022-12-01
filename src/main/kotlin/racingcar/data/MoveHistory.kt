package racingcar.data

class MoveHistory {
    private val moveHistory = LinkedHashMap<String, ArrayList<Int>>()

    fun addMove(moveInfo: MoveInfo) {
        val carMoves = moveHistory[moveInfo.carName] ?: ArrayList<Int>().apply {
            moveHistory[moveInfo.carName] = this
        }

        carMoves.add(moveInfo.moveCount)
    }

    fun getMoveHistory(): Map<String, List<Int>> = moveHistory

    fun getWinningCarNames(): List<String> {
        val racingCount = moveHistory.values.first().size

        val maxMoveCount = moveHistory.values.maxOfOrNull {
            it[racingCount - 1]
        } ?: 0

        return moveHistory.entries.filter {
            it.value[racingCount - 1] == maxMoveCount
        }.map { it.key }
    }
}

package racingcar.domain

class MoveHistory {
    val moveHistory: Map<String, List<Int>> = LinkedHashMap()

    fun addMoveInfos(moveInfos: List<MoveInfo>) {
        moveInfos.forEach {
            addMove(it)
        }
    }

    fun addMove(moveInfo: MoveInfo) {
        val moveList = mutableListOf<Int>()
        moveList.addAll(moveHistory[moveInfo.carName] ?: emptyList())
        moveList.add(moveInfo.moveCount)
        (moveHistory as LinkedHashMap)[moveInfo.carName] = moveList
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

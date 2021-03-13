package car.business

class CarMoveHistoryCollection(moveHistories: List<CarMoveHistory>) {
    val moveHistories: List<CarMoveHistory> = moveHistories
    private val maxPosition: Int
        get() = getMaxPositionOfMoveHistories()

    fun getWinners(): List<CarMoveHistory> {
        return moveHistories.filter { it.isWinner(maxPosition) }
    }

    private fun getMaxPositionOfMoveHistories(): Int {
        return moveHistories.map { it.position }.max()!!
    }
}

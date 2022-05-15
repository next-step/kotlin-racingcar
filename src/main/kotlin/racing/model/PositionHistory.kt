package racing.model

class PositionHistory(private val positionHistory: MutableList<CarMoveResult>) {
    fun save(moveResult: CarMoveResult) {
        positionHistory.add(moveResult)
    }

    fun size(): Int {
        return positionHistory.size
    }

    fun getMaxPositionCarName(): List<String> {
        val maxPosition = positionHistory.maxOf { it.position }
        return positionHistory
            .filter { it.position == maxPosition }
            .map { it.name }
    }

    fun forEach(action: (CarMoveResult) -> Unit) = positionHistory.forEach(action)
}

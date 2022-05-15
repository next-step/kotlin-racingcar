package racing.model

class PositionHistory(private val positionHistory: MutableList<CarMoveResult>) {
    fun save(position: CarMoveResult) {
        positionHistory.add(position)
    }

    fun size(): Int {
        return positionHistory.size
    }

    fun forEach(action: (CarMoveResult) -> Unit) = positionHistory.forEach(action)
}

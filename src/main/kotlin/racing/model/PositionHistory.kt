package racing.model

class PositionHistory(private val positionHistory: List<CarMoveResult>) {
    fun getMaxPositionCarName(): Names {
        val maxPosition = positionHistory.maxOf { it.position }
        return Names(
            positionHistory
                .filter { it.position.isMaxPosition(maxPosition) }
                .map { it.name }
        )
    }

    fun forEach(action: (CarMoveResult) -> Unit) = positionHistory.forEach(action)
}

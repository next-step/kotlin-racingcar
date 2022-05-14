package racing.model

class TotalPositionHistory(private val totalPositionHistory: MutableList<PositionHistory>) {
    fun save(positionHistory: PositionHistory) {
        totalPositionHistory.add(positionHistory)
    }

    fun forEach(action: (PositionHistory) -> Unit) = totalPositionHistory.forEach(action)
}

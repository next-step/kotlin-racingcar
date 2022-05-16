package racing.model

class TotalPositionHistory(private val totalPositionHistory: List<PositionHistory>) {
    fun forEach(action: (PositionHistory) -> Unit) = totalPositionHistory.forEach(action)

    fun findWinnersName(): Names {
        return totalPositionHistory[totalPositionHistory.size - 1].getMaxPositionCarName()
    }
}

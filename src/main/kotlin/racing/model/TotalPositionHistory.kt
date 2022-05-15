package racing.model

class TotalPositionHistory(private val totalPositionHistory: MutableList<PositionHistory>) {
    fun save(positionHistory: PositionHistory) {
        totalPositionHistory.add(positionHistory)
    }

    fun forEach(action: (PositionHistory) -> Unit) = totalPositionHistory.forEach(action)

    fun findWinnersName(): List<String> {
        return totalPositionHistory[totalPositionHistory.size - 1].getMaxPositionCarName()
    }
}

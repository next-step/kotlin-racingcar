package racing.model

class PositionHistory(private val positionHistory: MutableList<Int>) {
    fun save(position: Int) {
        positionHistory.add(position)
    }

    fun getPosition(index: Int): Int {
        return positionHistory[index]
    }

    fun size(): Int {
        return positionHistory.size
    }

    fun forEach(action: (Int) -> Unit) = positionHistory.forEach(action)
}

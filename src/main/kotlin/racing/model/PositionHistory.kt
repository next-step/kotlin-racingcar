package racing.model

class PositionHistory(private val positionHistory: MutableList<Int>) {
    fun save(position: Int) {
        positionHistory.add(position)
    }

    fun size(): Int {
        return positionHistory.size
    }

    fun getPosition(index: Int): Int {
        return positionHistory[index]
    }
}

package car.domain

class GameRecords {
    private val _records = mutableListOf<List<Record>>()
    val records: List<List<Record>>
        get() = _records.toList()

    private val latestRecord: List<Record>
        get() = _records.lastOrNull() ?: emptyList()

    val winners: List<Record>
        get() {
            val farthestMoves = latestRecord.getFarthestMoves()
            return if (farthestMoves == 0) {
                emptyList()
            } else {
                latestRecord.filter { it.moves == farthestMoves }
            }
        }

    private fun List<Record>.getFarthestMoves(): Int {
        return maxOfOrNull { it.moves } ?: 0
    }

    fun record(cars: Cars) {
        _records.add(cars.getAllRecord())
    }

    fun reset(): Unit = _records.clear()

    fun isRecorded(): Boolean = _records.isNotEmpty()
}

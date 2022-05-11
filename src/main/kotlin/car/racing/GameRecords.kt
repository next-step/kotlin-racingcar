package car.racing

class GameRecords {
    private val _records = mutableListOf<List<Record>>()
    val records: List<List<Record>>
        get() = _records

    private val latestRecord: List<Record>
        get() = _records.lastOrNull() ?: emptyList()

    val winners: List<Record>
        get() {
            val highestMoves = latestRecord.getHighestMoves()
            return if (highestMoves == 0) emptyList()
            else latestRecord.filter { it.moves == highestMoves }
        }

    private fun List<Record>.getHighestMoves(): Int {
        return maxByOrNull { it.moves }?.moves ?: 0
    }

    fun record(cars: Cars) {
        _records.add(cars.getAllRecord())
    }

    fun reset(): Unit = _records.clear()

    fun isRecorded(): Boolean = _records.isNotEmpty()
}

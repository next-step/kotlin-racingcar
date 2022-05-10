package car.racing

class GameRecords {
    private val _records = mutableListOf<List<Int>>()
    val records: List<List<Int>>
        get() = _records

    fun record(cars: Cars) {
        _records.add(cars.getAllMoves())
    }

    fun reset(): Unit = _records.clear()
}

package car.racing

class GameRecords {
    private val _records = mutableListOf<List<Record>>()
    val records: List<List<Record>>
        get() = _records

    fun record(cars: Cars) {
        _records.add(cars.getAllRecord())
    }

    fun reset(): Unit = _records.clear()

    fun isRecorded(): Boolean = _records.isNotEmpty()
}

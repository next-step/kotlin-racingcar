package racingcar.dto

data class GameResult(
    private val records: MutableList<Record> = mutableListOf()
) : List<Record> by records {
    fun addRecord(record: Record) {
        records.add(record)
    }

    fun getLastRoundRecord(): Record {
        return records.last()
    }
}

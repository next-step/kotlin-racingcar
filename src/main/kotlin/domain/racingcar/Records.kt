package domain.racingcar

class Records(private val records: List<Record>) {
    fun forEach(action: (Record) -> Unit) {
        records.forEach(action)
    }

    fun getByIndex(index: Int): Record {
        return records[index]
    }
}

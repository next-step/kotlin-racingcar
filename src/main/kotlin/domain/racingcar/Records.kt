package domain.racingcar

class Records(val records: List<Record>) {
    fun getByIndex(index: Int): Record {
        return records[index]
    }
}

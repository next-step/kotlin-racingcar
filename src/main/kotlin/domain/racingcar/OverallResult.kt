package domain.racingcar

class OverallResult(private val records: List<Records>) {
    fun forEach(action: (Records) -> Unit) {
        records.forEach(action)
    }

    fun getByIndex(index: Int): Records {
        return records[index]
    }

    fun getSize(): Int {
        return records.size
    }
}

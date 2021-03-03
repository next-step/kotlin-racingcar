package step3

class Records(val records: List<Record>) {
    fun size() = records.size
    operator fun get(i: Int) = records[i]
}

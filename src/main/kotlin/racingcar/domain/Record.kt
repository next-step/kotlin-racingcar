package racingcar.domain

class Record(
    private val record: MutableMap<Int, Cars> = mutableMapOf()
) {
    fun add(count: Int, cars: Cars) {
        record[count] = cars
    }

    fun getRecord(key: Int): Cars? {
        return record[key]
    }

    fun getSize(): Int {
        return record.size
    }
}

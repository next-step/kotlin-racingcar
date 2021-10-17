package racingcar.domain

/**
 * 경기를 기록한다.
 */
data class Record(private val record: MutableMap<Int, Cars>) {
    constructor() : this(mutableMapOf<Int, Cars>())

    fun add(count: Int, cars: Cars) {
        record[count] = cars
    }

    operator fun get(key: Int): Cars? = record[key]

    fun getSize(): Int {
        return record.size
    }
}

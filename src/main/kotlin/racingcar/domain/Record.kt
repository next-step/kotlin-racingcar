package racingcar.domain

/**
 * 경기를 기록한다.
 */
data class Record(private val record: Map<Int, Cars>) {
    fun add(pair: Pair<Int, Cars>): Record {
        return Record(record + pair)
    }

    operator fun get(key: Int): Cars? = record[key]

    fun getSize(): Int {
        return record.size
    }

    companion object {
        var EMPTY = Record(emptyMap<Int, Cars>())
    }
}

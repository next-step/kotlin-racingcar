package racinggame.record

class Records(val records: List<Record>) {
    init {
        if (records.isNullOrEmpty()) {
            throw IllegalArgumentException("기록이 존재하지 않습니다.")
        }
    }

    fun size() = records.size

    fun getTime(): Int {
        return records[0].time
    }

    fun findWinners(): List<Record> {
        val maxDistance = records.maxBy { it.distance }!!.distance
        return records.filter { it.distance == maxDistance }
    }
}

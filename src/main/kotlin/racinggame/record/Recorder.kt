package racinggame.record

class Recorder(val records: MutableList<Records>) {
    fun record(records: Records) {
        this.records.add(records)
    }

    fun getWinners(): List<Record> {
        if (records.isNullOrEmpty()) {
            throw IllegalArgumentException("녹화된 기록이 없습니다.")
        }
        return records.maxBy { it.getTime() }!!.findWinners()
    }

    companion object {
        fun zero() = Recorder(mutableListOf())
    }
}

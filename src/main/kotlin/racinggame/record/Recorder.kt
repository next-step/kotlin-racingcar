package racinggame.record

class Recorder(val records: MutableList<Records>) {
    fun record(records: Records) {
        this.records.add(records)
    }

    companion object {
        fun zero() = Recorder(mutableListOf())
    }
}

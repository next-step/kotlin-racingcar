package racingcar

class RaceResult(records: List<Record>) {
    private val records: List<Record> = ArrayList(records)

    fun toMap(): Map<Round, List<Record>> {
        return records.groupBy { it.round }
    }
}

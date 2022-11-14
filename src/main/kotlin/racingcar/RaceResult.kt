package racingcar

class RaceResult(private val records: List<Record>) {
    fun toMap(): Map<Round, List<Record>> {
        return records.groupBy { it.round }
    }
}

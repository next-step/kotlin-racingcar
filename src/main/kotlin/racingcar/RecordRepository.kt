package racingcar

object RecordRepository {
    val recordDataSet = mutableListOf<Record>()

    val gameRecords: List<LinkedHashMap<String, Int>>
        get() = recordDataSet.map { it.carNamesAndDistances }

    fun save(nth: Int, nthRecord: Record) {
        recordDataSet.add(nth, nthRecord)
    }

    fun findWinners(): List<String> {
        val finalRecord = recordDataSet.last().carNamesAndDistances

        return finalRecord.filter { it.value == findMaxDistance() }.map { it.key }
    }

    private fun findMaxDistance() =
        recordDataSet.last().carNamesAndDistances.maxBy { it.value }?.value
}

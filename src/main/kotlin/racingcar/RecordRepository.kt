package racingcar

object RecordRepository {
    val recordDataSet = mutableListOf<Record>()

    val gameRecords: List<LinkedHashMap<String, Int>>
        get() = recordDataSet.map { it.carNamesAndDistances }

    fun save(nth: Int, nthRecord: Record) {
        recordDataSet.add(nth, nthRecord)
    }

    fun findWinners() : List<String> {
        val winners = mutableListOf<String>()
        val finalRecord = recordDataSet.last().carNamesAndDistances

        winners.addAll( finalRecord.filter { it.value == findMaxDistance() }.map { it.key })

        return winners.toList()
    }

    private fun findMaxDistance() =
        recordDataSet.last().carNamesAndDistances.maxBy { it.value }?.value
}

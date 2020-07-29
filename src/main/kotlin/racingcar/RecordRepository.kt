package racingcar

object RecordRepository {
    private val _recordDataSet = mutableListOf<Record>()
    val recordDataSet: List<Record>
        get() = _recordDataSet

    val gameRecords: List<LinkedHashMap<String, Int>>
        get() = _recordDataSet.map { it.carNamesAndDistances }

    fun save(nth: Int, nthRecord: Record) {
        _recordDataSet.add(nth, nthRecord)
    }

    fun findWinners(): List<String> {
        val winners = mutableListOf<String>()

        val finalCarNamesAndDistances = _recordDataSet[_recordDataSet.size - 1].carNamesAndDistances
        val longestDistance = finalCarNamesAndDistances.values.max()

        finalCarNamesAndDistances.forEach { (name, distance) ->
            if (distance == longestDistance)
                winners.add(name)
        }
        return winners.toList()
    }
}

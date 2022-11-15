package racingcar

data class Record(
    private val record: List<CarRecord>
) : List<CarRecord> by record {
    fun findFrontRunner(): List<CarRecord> {
        val maxPosition = record.maxOf { it.position }
        return record.filter { carRecord ->
            carRecord.position == maxPosition
        }
    }
}

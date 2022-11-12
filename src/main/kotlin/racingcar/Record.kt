package racingcar

data class Record(
    val record: List<CarRecord>
) : List<CarRecord> by record {
    fun findFrontRunner(): List<CarRecord> {
        val maxPosition = record.maxOf { it.position }
        return record.filter { carRecord ->
            carRecord.position == maxPosition
        }
    }
}

data class CarRecord(
    val name: String,
    val position: Int,
)

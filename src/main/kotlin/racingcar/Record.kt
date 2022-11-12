package racingcar

data class Record(
    val record: List<CarRecord>
) : List<CarRecord> by record {
    fun findFrontRunner(): List<CarRecord> {
        return emptyList()
    }
}

data class CarRecord(
    val name: String,
    val position: Int,
)

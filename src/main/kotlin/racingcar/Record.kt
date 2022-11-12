package racingcar

data class Record(
    val record: List<CarRecord>
) : List<CarRecord> by record

data class CarRecord(
    val name: String,
    val position: Int,
)
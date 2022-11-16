package racingcar.dto

data class Record(
    private val record: List<CarInfo>
) : List<CarInfo> by record {
    fun findFrontRunner(): List<CarInfo> {
        val maxPosition = record.maxOf { it.position }
        return record.filter { carRecord ->
            carRecord.position == maxPosition
        }
    }
}

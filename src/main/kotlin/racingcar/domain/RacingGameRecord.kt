package racingcar.domain

class RacingGameRecord(
    lapRecords: List<LapRecord> = emptyList()
) {
    private val _lapRecords = lapRecords.toMutableList()
    val lapRecords get() = _lapRecords.toList()

    fun add(lapRecord: LapRecord) {
        _lapRecords.add(lapRecord)
    }

    fun winner(): List<CarName> {
        return lapRecords.last()
            .winner()
    }
}

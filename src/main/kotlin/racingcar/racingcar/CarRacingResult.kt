package racingcar.racingcar

class CarRacingResult {
    var winners: List<Car> = emptyList()
    private val _records: MutableList<TurnRecord> = mutableListOf()

    val records: List<TurnRecord>
        get() = _records

    fun record(turnRecord: TurnRecord) {
        _records.add(turnRecord)
    }
}

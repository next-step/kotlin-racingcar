package racingcar.racingcar

class CarRacingResult {
    private val records: MutableList<TurnRecord> = mutableListOf()

    fun record(turnRecord: TurnRecord) {
        records.add(turnRecord)
    }

    fun getAll(): MutableList<TurnRecord> {
        return records
    }
}

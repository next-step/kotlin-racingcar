package racingcar

class RacingGameRecorder {
    private val _positionBoard = HashMap<Car, CarPositionRecord>()
    val positionBoard: Map<Car, CarPositionRecord> get() = _positionBoard.toMap()

    fun record(car: Car) {
        val record = _positionBoard.getOrDefault(car, CarPositionRecord(emptyList()))

        _positionBoard[car] = record.copy(positions = record.positions + car.position)
    }
}

data class CarPositionRecord(
    val positions: List<Int>,
)

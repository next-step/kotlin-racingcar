package racingcar.car

class Car(
    private val carName: String
) {
    private val _drivingRecord: MutableList<Position> = mutableListOf()
    val moveResult get() = MoveResults.MoveResult(carName, _drivingRecord.count { it == Position.MOVE })

    fun move() {
        _drivingRecord.add(Position.MOVE)
    }
}

package step3.racingcar.car

class Car {
    private val _drivingRecord: MutableList<Position> = mutableListOf()
    val drivingRecord get() = _drivingRecord.toList()
    val currentDrivingRecord get() = _drivingRecord.count { it == Position.MOVE }

    fun move() {
        _drivingRecord.add(Position.MOVE)
    }

    fun stop() {
        _drivingRecord.add(Position.STOP)
    }
}

package racingcar.car

class Car {
    private val _drivingRecord: MutableList<Position> = mutableListOf()
    val currentDrivingRecord get() = _drivingRecord.count { it == Position.MOVE }

    fun move() {
        _drivingRecord.add(Position.MOVE)
    }
}

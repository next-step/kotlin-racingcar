package step3.racingcar.car

class Car {
    private val _drivingRecord: MutableList<Position> = mutableListOf()
    val drivingRecord get() = _drivingRecord.toList()

    fun move() {
        _drivingRecord.add(Position.MOVE)
    }

    fun stop() {
        _drivingRecord.add(Position.STOP)
    }
}

package step3.racingcar.car

class Car {
    private val drivingRecord: MutableList<Position> = mutableListOf()

    fun getDrivingRecord(): List<Position> {
        return drivingRecord.toList()
    }

    fun move() {
        drivingRecord.add(Position.MOVE)
    }

    fun stop() {
        drivingRecord.add(Position.STOP)
    }

    fun isMovable(moveNumber: Int): Boolean {
        return moveNumber >= 4
    }
}

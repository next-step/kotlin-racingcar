package racingcar.car

class Car(moveCount: Int) {
    private val randomInts = randomListBy(range, moveCount)
    private val drivingPoints = randomInts.map { DrivingForce.pointBy(it) }
    private val initPosition = 0
    private val initPositions = arrayListOf(initPosition)
    private val positionsByStep = drivingPoints.fold(initPositions) { positions, point ->
        positions.add(positions.last() + point)
        positions
    }

    fun positionBy(step: Int): Int = positionsByStep[step]

    companion object {
        private val range = (0..9)
    }
}

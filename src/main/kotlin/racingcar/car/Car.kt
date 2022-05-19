package racingcar.car

class Car(moveCount: Int) {
    private val drivingForces = randomListBy(range, moveCount)
    private val drivingPoints = drivingForces.map { drivingPointBy(it) }
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

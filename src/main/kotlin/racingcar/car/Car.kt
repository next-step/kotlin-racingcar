package racingcar.car

class Car(moveCount: Int) {
    companion object {
        val range = (0..9)
    }

    private val randomInts = RandomList.intListBy(range, moveCount)
    private val drivingPoints = randomInts.map { i -> DrivingForce.pointBy(i) }
    private val initPositions = arrayListOf(0)
    private val positions = drivingPoints.fold(initPositions) { positions, point ->
        positions.add(positions.last() + point)
        positions
    }

    fun positionBy(step: Int): Int = positions[step]
}

package racingcar.car

class Car(val no: Int, moveCount: Int) {
    companion object {
        val range = (0..9)
    }

    private val randomInts = RandomList.intListBy(range, moveCount)
    private val drivingPoints = randomInts.map { i -> DrivingForce.pointBy(i) }
    private val positions: List<Int> = drivingPoints.fold(arrayListOf(0)) { positions: ArrayList<Int>, point: Int ->
        positions.add(positions.last() + point)
        positions
    }

    fun positionBy(step:Int): Int {
        return positions[step]
    }
}

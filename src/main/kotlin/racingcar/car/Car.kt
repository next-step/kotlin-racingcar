package racingcar.car

class Car {
    private val position = mutableMapOf<Int, Int>()

    fun positionBy(moveCount: Int): Int = if (moveCount < 1) initPosition else position.getOrPut(moveCount) {
        positionBy(moveCount - 1) + drivingPointBy(drivingForcePool.random())
    }

    companion object {
        private val drivingForcePool = (0..9)
        private const val initPosition = 0
    }
}

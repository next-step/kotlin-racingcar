package racingcar.domain

class Car private constructor(private val strategy: MoveStrategy) {
    var location: Int = 0
        private set

    fun move() {
        if (strategy.isMovable()) {
            forward()
        }
    }

    private fun forward() {
        location += MOVE_CNT
    }

    companion object {
        fun ofRandom(): Car {
            return Car(RandomMoveStrategy)
        }

        private const val MOVE_CNT = 1
    }
}
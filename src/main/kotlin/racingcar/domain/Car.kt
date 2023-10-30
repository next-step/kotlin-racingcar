package racingcar.domain

class Car private constructor(private val strategy: MoveStrategy) {
    var state = ""
        private set

    fun move() {
        if (strategy.isMovable()) {
            forward()
        }
    }

    private fun forward() {
        state += STATE_UNIT
    }

    companion object {
        fun ofRandom(): Car {
            return Car(RandomMoveStrategy)
        }

        const val STATE_UNIT = "-"
    }
}
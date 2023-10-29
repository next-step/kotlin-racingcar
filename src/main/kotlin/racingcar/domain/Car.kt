package racingcar.domain

class Car private constructor(private val moveCondition: MoveCondition) {
    var state = ""
        private set

    fun move() {
        if (moveCondition.strategy.isMovable()) {
            forward()
        }
    }

    private fun forward() {
        state += STATE_UNIT.repeat(moveCondition.moveCnt)
    }

    companion object {
        fun ofRandom(): Car {
            val randomMoveCondition = MoveCondition(
                strategy = RandomMoveStrategy,
                moveCnt = 1
            )
            return Car(randomMoveCondition)
        }

        const val STATE_UNIT = "-"
    }
}
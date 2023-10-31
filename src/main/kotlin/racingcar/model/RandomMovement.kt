package racingcar.model

class RandomMovement : MoveCondition {
    override fun isMovable(): Boolean {
        return (START_RANGE..END_RANGE).random() > THRESHOLD
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
        private const val THRESHOLD = 4
    }
}

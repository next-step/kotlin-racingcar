package racinggame

class Car(
    var position: Int = 0
) {
    fun move(movingCondition: Int) {
        if (isInvalidMovingCondition(movingCondition)) {
            throw IllegalArgumentException("$MOVING_CONDITION_ERROR_MESSAGE ($movingCondition)")
        }

        if (movingCondition >= MOVABLE_MINIMUM_CONDITION) {
            position++
        }
    }

    private fun isInvalidMovingCondition(movingCondition: Int) =
        movingCondition < MOVING_CONDITION_MIN || movingCondition > MOVING_CONDITION_MAX

    companion object {
        private const val MOVING_CONDITION_MIN = 0
        private const val MOVING_CONDITION_MAX = 9
        private const val MOVABLE_MINIMUM_CONDITION = 4

        const val MOVING_CONDITION_ERROR_MESSAGE = "전진 조건 수는 0에서 9 사이 정수이어야합니다"
    }
}

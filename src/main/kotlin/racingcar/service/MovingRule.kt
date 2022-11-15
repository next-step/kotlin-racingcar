package racingcar.service

interface MovingRule {
    fun isMoving(condition: Int = RANDOM_CONDITION_NUM): Boolean

    companion object {
        private const val RANDOM_CONDITION_NUM = -1
    }
}



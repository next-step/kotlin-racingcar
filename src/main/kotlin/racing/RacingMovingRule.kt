package racing

import kotlin.random.Random

data class RacingMovingRule(val movingCount: Int) {
    fun isMove(): Boolean {
        val random = Random.nextInt(RANDOM_START, RANDOM_END)
        return MOVING_VALUE <= random
    }

    companion object {
        private const val RANDOM_START = 0
        private const val MOVING_VALUE = 4
        private const val RANDOM_END = 10
    }
}

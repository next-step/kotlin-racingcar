package racingcar.service

import kotlin.random.Random

class CarMovingRule : MovingRule {
    override fun isMoving(condition: Int) = Random.nextInt(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= condition

    companion object {
        private const val RANDOM_MIN_NUM = 0
        private const val RANDOM_MAX_NUM = 9
    }
}

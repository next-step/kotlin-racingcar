package racingCar.strategy

import kotlin.random.Random

class MoveRandomStrategy : MoveStrategy {

    companion object {
        private const val RANDOM_LIMIT_NUM = 10
        private const val STANDARD_VALUE_TO_MOVE = 4
    }

    override fun isMove(): Boolean {
        return Random.nextInt(RANDOM_LIMIT_NUM) >= STANDARD_VALUE_TO_MOVE
    }
}

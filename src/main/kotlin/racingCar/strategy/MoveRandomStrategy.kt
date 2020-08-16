package racingCar.strategy

import kotlin.random.Random

class MoveRandomStrategy : MoveStrategy {

    companion object {
        private const val RANDOM_LIMIT_NUM = 10
    }

    override fun moveCar(): Int {
        return Random.nextInt(RANDOM_LIMIT_NUM)
    }
}

package racingcar.strategy

import kotlin.random.Random

class RandomMoveStrategy : MoveStrategy {

    override fun getMoveCount(): Int {
        return random.nextInt(RANDOM_MAX_VALUE)
    }

    companion object {
        private const val RANDOM_MAX_VALUE = 10
        private val random = Random.Default
    }
}

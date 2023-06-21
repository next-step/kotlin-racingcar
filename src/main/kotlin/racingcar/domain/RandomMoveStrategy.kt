package racingcar.domain

import kotlin.random.Random

class RandomMoveStrategy: MoveStrategy {

    companion object {
        private const val MINIMUM_MOVABLE_NUMBER = 4
        private const val MAXIMUM_MOVABLE_NUMBER = 10
    }

    override fun movable(): Boolean {
        return Random.nextInt(MAXIMUM_MOVABLE_NUMBER) >= MINIMUM_MOVABLE_NUMBER
    }
}

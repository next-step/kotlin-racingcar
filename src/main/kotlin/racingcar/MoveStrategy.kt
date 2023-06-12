package racingcar

import kotlin.random.Random

private const val MOVE_VALUE = 4

class RandomNumStrategy : MoveStrategy {
    override fun move(): Boolean {
        return Random.nextInt(10) >= MOVE_VALUE
    }
}

interface MoveStrategy {
    fun move(): Boolean
}

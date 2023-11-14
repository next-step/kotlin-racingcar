package racingcar.domain

import kotlin.random.Random

interface MoveStrategy {
    fun isMovable(): Boolean
}

object RandomMoveStrategy: MoveStrategy {
    private const val FORWARD_CONDITION_NUMBER = 4
    private const val MAX_RANGE_NUMBER = 9
    override fun isMovable(): Boolean = Random.nextInt(MAX_RANGE_NUMBER) >= FORWARD_CONDITION_NUMBER
}

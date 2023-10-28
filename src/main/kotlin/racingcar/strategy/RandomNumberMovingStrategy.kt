package racingcar.strategy

import kotlin.random.Random

private const val RANDOM_MAX_BOUND = 10
private const val BOUND_CONDITION = 4

class RandomNumberMovingStrategy: MovingStrategy {
    override fun canMove(): Boolean {
        val randomInt = Random.nextInt(RANDOM_MAX_BOUND)
        return randomInt >= BOUND_CONDITION
    }
}

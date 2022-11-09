package racing.domain.strategy

import kotlin.random.Random

class RandomMovingStrategy : MovingStrategy {
    companion object {
        const val MOVEMENT_CONDITION = 4
        const val MOVEMENT_RANGE_MAX = 10
    }

    override fun isMove(): Boolean = Random.nextInt(MOVEMENT_RANGE_MAX) >= MOVEMENT_CONDITION
}

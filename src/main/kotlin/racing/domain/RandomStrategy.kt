package racing.domain

import java.util.Random

class RandomStrategy : MovingStrategy {
    companion object {
        const val MOVING_POINT = 4
        const val MOVING_RANGE_MAX = 10
    }

    override fun move(): Boolean = Random().nextInt(MOVING_RANGE_MAX) >= MOVING_POINT
}

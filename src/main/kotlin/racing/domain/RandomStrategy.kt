package racing.domain

import java.util.Random

class RandomStrategy : MovingStrategy {
    companion object {
        const val MOVING_POINT = 4
    }

    override fun go(): Boolean {
        val random = Random().nextInt(10)
        return random >= MOVING_POINT
    }
}

package racing.domain

import java.util.Random
import java.util.concurrent.ThreadLocalRandom

class RandomMovingStrategy : MovingStrategy {
    private val random: Random = ThreadLocalRandom.current()

    companion object {
        private const val RANDOM_BOUND = 9
        private const val TARGET_NUMBER = 4
    }

    override fun isMovable(): Boolean {
        return random.nextInt(RANDOM_BOUND) >= TARGET_NUMBER
    }
}

package week1.racing.domain

import kotlin.random.Random

fun interface MovementDecider {
    fun shouldMove(): Boolean
}

class CarMovementDecider : MovementDecider {
    override fun shouldMove(): Boolean {
        return Random.nextInt(until = RANDOM_UNTIL) >= MIN_FORWARD_THRESHOLD
    }

    companion object {
        private const val RANDOM_UNTIL = 9
        private const val MIN_FORWARD_THRESHOLD = 4
    }
}

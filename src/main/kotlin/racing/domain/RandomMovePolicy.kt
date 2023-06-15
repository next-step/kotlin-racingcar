package racing.domain

import kotlin.random.Random

class RandomMovePolicy : MovePolicy {
    override fun isMovable(): Boolean {
        val randomNumber = Random.nextInt(MIN_NUMBER, MAX_NUMBER + 1)
        return randomNumber >= MOVABLE_THRESHOLD
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 9
        private const val MOVABLE_THRESHOLD = 4
    }
}

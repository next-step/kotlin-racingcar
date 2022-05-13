package racingcar.model.movement

import kotlin.random.Random
import kotlin.random.nextInt

class DefaultMovement : Movement {
    companion object {
        private val RANGE_FOR_RANDOM_INT = 0..9
        private const val MIN_VALUE_TO_MOVE = 4
    }

    override fun canMoveNow() = Random.nextInt(RANGE_FOR_RANDOM_INT) >= MIN_VALUE_TO_MOVE
}

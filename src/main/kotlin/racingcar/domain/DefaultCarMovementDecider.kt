package racingcar.domain

import kotlin.random.Random.Default.nextInt

class DefaultCarMovementDecider : CarMovementDecider {
    override fun canMove(): Boolean {
        return nextInt(MOVE_FORWARD_CONDITION_BOUNDS) >= MOVE_FORWARD_THRESHOLD
    }

    companion object {
        private const val MOVE_FORWARD_CONDITION_BOUNDS = 10
        private const val MOVE_FORWARD_THRESHOLD = 4
    }
}

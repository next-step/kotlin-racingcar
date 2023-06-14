package racingcar.model

import kotlin.random.Random

data class RandomMoveStrategy(private val random: Random = Random.Default) : MoveStrategy {

    override val movedStatus: MovingStatus
        get() = if (MOVABLE_LIMIT <= random.nextInt(MAX_NUMBER)) {
            MovingStatus.GO
        } else {
            MovingStatus.STOP
        }

    companion object {
        private const val MOVABLE_LIMIT: Int = 4
        private const val MAX_NUMBER: Int = 10
    }
}

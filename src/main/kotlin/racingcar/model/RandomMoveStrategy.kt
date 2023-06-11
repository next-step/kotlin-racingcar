package racingcar.model

import kotlin.random.Random

data class RandomMoveStrategy(private val random: Random = Random.Default) : MoveStrategy {

    override val movedStatus: MovingStatus
        get() = if (random.nextInt(MAX_NUMBER) >= MOVABLE_LIMIT) {
            MovingStatus.GO
        } else {
            MovingStatus.STOP
        }

    companion object {
        private const val MOVABLE_LIMIT: Int = 4
        private const val MAX_NUMBER: Int = 10
    }
}

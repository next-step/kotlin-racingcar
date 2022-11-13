package racing.domain

class RandomMoveStrategy(
    private val randomRange: IntRange = DEFAULT_MOVING_CAR_CONDITION_RANGE
) : MoveStrategy {

    override fun move(): Boolean =
        randomRange.random() >= MOVE_CONDITION

    companion object {
        private val DEFAULT_MOVING_CAR_CONDITION_RANGE = 0..9
        private const val MOVE_CONDITION = 4
    }
}

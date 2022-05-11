package racinggame.domain.engine

object RandomEngine : Engine {
    private const val STANDARD_OF_GOOD_CONDITION = 4
    const val MOVE_SUCCESS = 1
    const val MOVE_FAIL = 0

    override fun getMovableDistance() = if (isOperable()) MOVE_SUCCESS else MOVE_FAIL

    private fun isOperable() = getCurrentCondition() >= STANDARD_OF_GOOD_CONDITION

    private fun getCurrentCondition() = (0..9).random()
}

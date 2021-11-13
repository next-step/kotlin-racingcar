package racingcar.domain.racing

class RacingDistance(
    val value: Int = START_DISTANCE
) {
    init {
        require(START_DISTANCE <= value)
    }

    fun increase(): RacingDistance = RacingDistance(value + MOVE_ONE_STEP_FORWARD)

    companion object {
        private const val START_DISTANCE = 0
        private const val MOVE_ONE_STEP_FORWARD = 1
    }
}

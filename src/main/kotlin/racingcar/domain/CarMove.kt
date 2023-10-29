package racingcar.domain

object CarMove {
    private val CAR_RACING_RANDOM_RANGE = IntRange(0, 9)
    private const val CAR_MOVE_FORWARD_CONDITION = 4

    fun canMoveForward(): Boolean = CAR_MOVE_FORWARD_CONDITION >= CAR_RACING_RANDOM_RANGE.random()
}

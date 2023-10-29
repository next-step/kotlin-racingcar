package racingcar.domain

object CarMove {
    const val CAR_RACING_RANDOM_START = 0
    const val CAR_RACING_RANDOM_END = 9
    private const val CAR_MOVE_FORWARD_CONDITION = 4
    fun canMoveForward(number: Int): Boolean = CAR_MOVE_FORWARD_CONDITION >= number
}

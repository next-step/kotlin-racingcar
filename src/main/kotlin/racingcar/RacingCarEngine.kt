package racingcar

private const val FORWARD_VALUE = 4

enum class RacingCarEngine {
    FORWARD, NON_FORWARD;

    companion object {
        fun canMove(moveValue: Int): RacingCarEngine {
            if (moveValue < FORWARD_VALUE) {
                return NON_FORWARD
            }

            return FORWARD
        }
    }
}

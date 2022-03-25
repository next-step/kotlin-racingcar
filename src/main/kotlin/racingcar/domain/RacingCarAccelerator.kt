package racingcar.domain

class RacingCarAccelerator : CarAccelerator {

    override fun trigger(): CarAction {
        return if (MOVE_CONDITION.random() >= MOVE_CONDITION_STANDARD) CarAction.MOVE
        else CarAction.STOP
    }

    companion object {
        private const val MOVE_CONDITION_START = 0
        private const val MOVE_CONDITION_END = 9
        private const val MOVE_CONDITION_STANDARD = 4
        private val MOVE_CONDITION = (MOVE_CONDITION_START..MOVE_CONDITION_END)
    }
}

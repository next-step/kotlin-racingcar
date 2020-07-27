package racingcar

class RacingCar {
    companion object {
        private const val CAN_MOVE_FROM = 4
        private const val CAN_MOVE_TO = 9
    }

    var distance: Int = 0

    fun run(randomNum: Int) {
        if (isRunnable(randomNum)) distance++
    }

    private fun isRunnable(randomNum: Int) = randomNum in CAN_MOVE_FROM..CAN_MOVE_TO
}

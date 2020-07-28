package racingcar

class RacingCar {
    companion object {
        private const val CAN_RUN_FROM = 4
        private const val CAN_RUN_TO = 9
    }

    private var distance: Int = 0

    fun getTotalDistance() = distance

    fun run(randomNum: Int) {
        if (isRunnable(randomNum)) distance++
    }

    private fun isRunnable(randomNum: Int) = randomNum in CAN_RUN_FROM..CAN_RUN_TO
}

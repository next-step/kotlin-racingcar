package racingcar

class Car(
    val name: String
) {
    private var _distance: Int = 0
    val distance: Int
        get() = _distance

    fun run(flag: Int) {
        if (isRunnable(flag)) _distance++
    }

    private fun isRunnable(flag: Int) = flag in CAN_RUN_FROM..CAN_RUN_TO

    companion object {
        private const val CAN_RUN_FROM = 4
        private const val CAN_RUN_TO = 9
    }
}

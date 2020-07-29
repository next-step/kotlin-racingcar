package racingcar

class Car(val name: String) {
    private var _distance: Int = 0
    val distance: Int
        get() = _distance

    fun run(flag: Int) {
        if (isRunnable(flag)) _distance++
    }

    private fun isRunnable(flag: Int) = flag >= MAKE_RUNNABLE_VALUE

    companion object {
        private const val MAKE_RUNNABLE_VALUE = 4
    }
}

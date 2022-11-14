package racingcar.racingcar

data class Car(
    val name: String
) {
    private var distance: Int = 0

    fun go(number: Int) {
        if (canIGo(number)) {
            forward()
        }
    }

    private fun canIGo(number: Int): Boolean {
        return number in AVAILABLE_RANGE
    }

    private fun forward() {
        distance += MINIMUM_DISTANCE
    }

    fun currentDistance(): Int {
        return distance
    }

    companion object {
        private const val MINIMUM_DISTANCE = 1
        private val AVAILABLE_RANGE = 4..9
    }
}

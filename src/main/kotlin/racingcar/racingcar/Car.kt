package racingcar.racingcar

class Car(
    private val indicator: Indicator
) {
    private var currentLocation: Int = 0

    fun go(turn: Int) {
        val current = indicator.current(turn)
        if (canIGo(current)) {
            forward()
        }
    }

    private fun canIGo(number: Int): Boolean {
        val intRange = AVAILABLE_RANGE
        return number in intRange
    }

    private fun forward() {
        currentLocation += MINIMUM_DISTANCE
    }

    fun currentLocation(): Int {
        return currentLocation
    }

    companion object {
        const val MINIMUM_DISTANCE = 1
        val AVAILABLE_RANGE = 4..9
    }
}

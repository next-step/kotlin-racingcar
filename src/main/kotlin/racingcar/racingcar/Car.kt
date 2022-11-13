package racingcar.racingcar

class Car {
    private var currentLocation: Int = 0

    fun go(number: Int) {
        if (canIGo(number)) {
            forward()
        }
    }

    private fun canIGo(number: Int): Boolean {
        return number in AVAILABLE_RANGE
    }

    private fun forward() {
        currentLocation += MINIMUM_DISTANCE
    }

    fun currentLocation(): Int {
        return currentLocation
    }

    companion object {
        private const val MINIMUM_DISTANCE = 1
        private val AVAILABLE_RANGE = 4..9
    }
}

package racingcar

class Car() {
    var currentPosition: Int = 0
        private set

    fun accelerate(fuel: Int) {
        if (canAccelerate(fuel)) {
            increaseCurrentPosition()
        }
    }

    private fun canAccelerate(fuel: Int): Boolean {
        return fuel >= MIN_FUEL_THRESHOLD
    }

    private fun increaseCurrentPosition() {
        currentPosition += 1
    }

    companion object {
        const val MIN_FUEL_THRESHOLD = 4
    }
}

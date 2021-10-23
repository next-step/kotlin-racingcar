package racingcar

class Car(val carId: Int) {
    private var _currentPosition: Int = 0
    val currentPosition: Int
        get() = _currentPosition

    fun accelerate(fuel: Int) {
        if (canAccelerate(fuel)) {
            increaseCurrentPosition()
        }
    }

    private fun canAccelerate(fuel: Int): Boolean {
        return fuel >= MIN_FUEL_THRESHOLD
    }

    private fun increaseCurrentPosition() {
        _currentPosition += 1
    }

    companion object {
        const val MIN_FUEL_THRESHOLD = 4
    }
}

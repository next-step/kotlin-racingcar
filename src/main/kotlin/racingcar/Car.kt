package racingcar

const val DefaultMinFuelThreshold = 4

class Car(val carId: Int, private val minFuelThreshold: Int = DefaultMinFuelThreshold) {
    var currentPosition: Int = 0

    fun accelerate(fuel: Int) {
        if (canAccelerate(fuel)) {
            increaseCurrentPosition()
        }
    }

    private fun canAccelerate(fuel: Int): Boolean {
        return fuel > minFuelThreshold
    }

    private fun increaseCurrentPosition() {
        currentPosition += 1
    }
}

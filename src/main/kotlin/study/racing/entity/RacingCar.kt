package study.racing.entity

class RacingCar {
    var currentPosition: Int = 0
        private set

    fun moveForward() {
        if (canMoveForward) {
            currentPosition += 1
        }
    }

    private val canMoveForward: Boolean get() = POWER_RANGE.random() >= POWER_THRESHOLD

    companion object {
        private val POWER_RANGE = 0..9
        private const val POWER_THRESHOLD = 4
    }
}
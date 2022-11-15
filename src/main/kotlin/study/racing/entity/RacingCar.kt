package study.racing.entity

import study.racing.PowerSource

class RacingCar(
    private val source: PowerSource
) {
    var currentPosition: Int = START_POSITION
        private set

    fun moveForward() {
        if (canMoveForward) {
            currentPosition += MOVE_INTERVAL
        }
    }

    private val canMoveForward: Boolean get() = source.getPower() >= POWER_THRESHOLD

    companion object {
        private const val START_POSITION = 0
        private const val MOVE_INTERVAL = 1
        private const val POWER_THRESHOLD = 4
    }
}
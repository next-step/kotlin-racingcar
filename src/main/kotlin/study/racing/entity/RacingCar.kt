package study.racing.entity

import study.racing.PowerSource

class RacingCar(
    private val source: PowerSource
) {
    var currentPosition: Int = 0
        private set

    fun moveForward() {
        if (canMoveForward) {
            currentPosition += 1
        }
    }

    private val canMoveForward: Boolean get() = source.getPower() >= POWER_THRESHOLD

    companion object {
        private const val POWER_THRESHOLD = 4
    }
}
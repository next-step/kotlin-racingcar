package study.racing.domain.repository

import study.racing.PowerSource

class RacingCarRepository(
    private val powerSource: PowerSource,
) {
    fun getPower(): Int = powerSource.getPower()

    fun canMoveForward(power: Int): Boolean = power >= POWER_THRESHOLD

    companion object {
        private const val POWER_THRESHOLD = 4
    }
}
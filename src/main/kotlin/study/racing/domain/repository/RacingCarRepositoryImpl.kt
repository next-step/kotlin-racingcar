package study.racing.domain.repository

import study.racing.data.PowerSource

class RacingCarRepositoryImpl(
    private val powerSource: PowerSource,
): RacingCarRepository {
    override fun getPower(): Int = powerSource.getPower()

    override fun canMoveForward(power: Int): Boolean = power >= POWER_THRESHOLD

    companion object {
        private const val POWER_THRESHOLD = 4
    }
}
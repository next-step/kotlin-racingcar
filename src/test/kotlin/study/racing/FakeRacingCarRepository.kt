package study.racing

import study.racing.domain.repository.RacingCarRepository

class FakeRacingCarRepository(
    private val power: Int,
    private val canMoveForward: Boolean,
) : RacingCarRepository {
    override fun getPower(): Int = power

    override fun canMoveForward(power: Int): Boolean = canMoveForward
}
package study.racing.domain.repository

import study.racing.PowerSource

interface RacingCarRepository {
    fun getPower(): Int
    fun canMoveForward(power: Int): Boolean
}

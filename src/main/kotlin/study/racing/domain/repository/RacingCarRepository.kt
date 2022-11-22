package study.racing.domain.repository

interface RacingCarRepository {
    fun getPower(): Int
    fun canMoveForward(power: Int): Boolean
}

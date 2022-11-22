package study.racing.domain.entity

import study.racing.domain.repository.RacingCarRepository

class RacingCar(
    val name: String,
    private val repo: RacingCarRepository
) {
    var currentPosition: Int = START_POSITION
        private set

    fun moveForward() {
        if (canMoveForward(repo.getPower())) {
            currentPosition += MOVE_INTERVAL
        }
    }

    private fun canMoveForward(power: Int): Boolean = repo.canMoveForward(power)

    companion object {
        private const val START_POSITION = 0
        private const val MOVE_INTERVAL = 1
    }
}

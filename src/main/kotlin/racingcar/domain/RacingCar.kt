package racingcar.domain

import racingcar.domain.carracer.CarRacer

private const val DEFAULT_MOVEMENT = 0
private const val MOVING_BENCHMARK = 4

class RacingCar(private val carRacer: CarRacer) {

    var movement = DEFAULT_MOVEMENT
        private set

    fun move() {
        if (canMove()) {
            movement++
        }
    }

    private fun canMove() = carRacer.drive() >= MOVING_BENCHMARK
}

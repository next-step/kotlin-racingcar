package racingcar.domain

import racingcar.domain.carracer.CarRacer

private const val DEFAULT_MOVEMENT = 0
private const val MOVING_BENCHMARK = 4

class RacingCar(private val carRacer: CarRacer, movement: Int = DEFAULT_MOVEMENT) {

    var movement = movement
        private set

    fun move() {
        if (canMove(carRacer.race())) {
            movement++
        }
    }

    private fun canMove(random: Int) = random >= MOVING_BENCHMARK
}

package racingcar.model

import racingcar.strategy.MovingStrategy

class RacingCarGame(
    val cars: List<Car>,
    private val strategy: MovingStrategy,
) {
    fun run() {
        for (car in cars) {
            car.stepForward(strategy.canMove())
        }
    }
}

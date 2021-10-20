package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy

data class RacingCar(
    private val _distanceDriven: DistanceDriven = DistanceDriven(),
    private val movingStrategy: MovingStrategy
) {

    val distance: Int
        get() = _distanceDriven.distanceDriven

    fun moveForward(): RacingCar {
        if (movingStrategy.movable()) {
            return RacingCar(_distanceDriven.moveForward(), movingStrategy)
        }
        return this
    }
}

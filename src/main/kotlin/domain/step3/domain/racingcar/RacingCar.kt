package domain.step3.domain.racingcar

import domain.step3.domain.strategy.MovingStrategy

data class RacingCar(
    private val _distanceDriven: DistanceDriven = DistanceDriven(),
    private val movingStrategy: MovingStrategy
) {

    val distance: Int
        get() = _distanceDriven.distanceDriven

    fun move(): RacingCar {
        if (movingStrategy.movable()) {
            return RacingCar(_distanceDriven.move(), movingStrategy)
        }
        return this
    }
}

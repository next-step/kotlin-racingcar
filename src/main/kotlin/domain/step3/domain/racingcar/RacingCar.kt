package domain.step3.domain.racingcar

import domain.step3.domain.strategy.MovingStrategy

class RacingCar(
    private val _distanceDriven: DistanceDriven = DistanceDriven(),
    private val movingStrategy: MovingStrategy
) {

    fun move(): RacingCar {
        if (movingStrategy.movable()) {
            return RacingCar(DistanceDriven(), movingStrategy)
        }
        return this
    }
}

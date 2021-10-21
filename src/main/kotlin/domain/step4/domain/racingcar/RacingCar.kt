package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy

data class RacingCar(
    val name: Name,
    private val _distanceDriven: DistanceDriven = DistanceDriven(),
    private val movingStrategy: MovingStrategy
) {

    val distance: Int
        get() = _distanceDriven.distanceDriven

    fun moveForward(): RacingCar {
        if (movingStrategy.movable()) {
            return RacingCar(name, _distanceDriven.moveForward(), movingStrategy)
        }
        return this
    }

    fun isWinner(otherDistance: Int): Boolean = distance >= otherDistance

}

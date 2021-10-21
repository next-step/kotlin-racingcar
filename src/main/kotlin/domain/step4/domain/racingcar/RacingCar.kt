package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy

data class RacingCar(
    val _name: Name,
    private val _distanceDriven: DistanceDriven = DistanceDriven(),
    private val movingStrategy: MovingStrategy
) {

    val name: String
        get() = _name.name

    val distance: Int
        get() = _distanceDriven.distanceDriven

    fun moveForward(): RacingCar {
        if (movingStrategy.movable()) {
            return RacingCar(_name, _distanceDriven.moveForward(), movingStrategy)
        }
        return this
    }

    fun isWinner(otherDistance: Int): Boolean = distance >= otherDistance

}

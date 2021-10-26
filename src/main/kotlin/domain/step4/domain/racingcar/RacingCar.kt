package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy

data class RacingCar(
    private val _name: Name,
    private val _distanceDriven: DistanceDriven = DistanceDriven(),
    private val movingStrategy: MovingStrategy
) {

    val name: String
        get() = _name.name

    val distance: Int
        get() = _distanceDriven.distanceDriven

    fun moveForward(): RacingCar {
        return when (movingStrategy.movable()) {
            true -> RacingCar(_name, _distanceDriven.moveForward(), movingStrategy)
            false -> this
        }
    }

    fun isWinner(otherDistance: Int): Boolean = distance >= otherDistance
}

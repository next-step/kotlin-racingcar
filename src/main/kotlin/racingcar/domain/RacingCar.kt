package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

data class RacingCar(
    val name: Name,
    val movingStrategy: MovingStrategy,
    val position: Position = Position.of()
) {

    fun move() = when {
        movingStrategy.movable() -> RacingCar(name, movingStrategy, position.move())
        else -> this
    }
}

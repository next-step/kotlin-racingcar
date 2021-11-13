package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.domain.vo.Name
import racingcar.domain.vo.Position

data class RacingCar(
    val name: Name,
    val movingStrategy: MovingStrategy,
    val position: Position = Position()
) {
    constructor(value: String, movingStrategy: MovingStrategy) : this(Name(value), movingStrategy)

    fun moved() = when {
        movingStrategy.isMovable() -> RacingCar(name, movingStrategy, position.moved())
        else -> this
    }
}

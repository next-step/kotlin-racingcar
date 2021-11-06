package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.domain.vo.Position

data class RacingCar(
    val movingStrategy: MovingStrategy,
    val position: Position = Position()
) {
    fun moved() = when {
        movingStrategy.isMovable() -> RacingCar(movingStrategy, position.moved())
        else -> this
    }
}

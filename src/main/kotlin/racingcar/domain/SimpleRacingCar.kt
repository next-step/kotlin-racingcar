package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.domain.vo.Position

data class SimpleRacingCar(
    override val movingStrategy: MovingStrategy,
    override val position: Position = Position()
) : RacingCar {
    override fun moved() = when {
        movingStrategy.isMovable() -> SimpleRacingCar(movingStrategy, position.moved())
        else -> this
    }
}

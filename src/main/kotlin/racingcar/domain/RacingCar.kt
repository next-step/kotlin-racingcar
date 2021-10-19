package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

data class RacingCar(val movingStrategy: MovingStrategy, val position: Position) {

    fun move() = when {
        movingStrategy.movable() -> RacingCar(movingStrategy, position.move())
        else -> this
    }
}

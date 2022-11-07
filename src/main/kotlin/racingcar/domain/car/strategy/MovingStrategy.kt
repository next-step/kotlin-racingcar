package racingcar.domain.car.strategy

import racingcar.domain.car.Position

interface MovingStrategy {

    fun move(position: Position): Position
}

package racingcar.domain.car.engine

import racingcar.domain.car.Position

interface MovingEngine {

    fun move(position: Position): Position
}

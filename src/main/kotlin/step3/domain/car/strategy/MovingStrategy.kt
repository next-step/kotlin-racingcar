package step3.domain.car.strategy

import step3.domain.car.Position

interface MovingStrategy {

    fun move(position: Position): Position
}

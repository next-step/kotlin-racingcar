package racingcar.domain

import racingcar.domain.move.MovingStrategy
import racingcar.vo.Position

class Car(
    val name: String,
    val position: Position = Position()
) {

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.canMove()) {
            position.move()
        }
    }
}

package racingcar.domain.car

import racingcar.domain.car.vo.Name
import racingcar.domain.car.vo.Position
import racingcar.domain.move.MovingStrategy

class Car(
    val name: Name,
    val position: Position = Position()
) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.canMove()) {
            position.move()
        }
    }

    companion object {
        fun of(name: String): Car {
            return Car(Name(name))
        }
    }
}

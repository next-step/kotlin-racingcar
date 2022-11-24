package racingcar.model.impl

import racingcar.model.Car
import racingcar.model.MoveFactor
import racingcar.model.Name
import racingcar.model.Position

private const val MOVE_THRESHOLD = 4
private const val DEFAULT_SPEED = 1

class CarImpl(
    override val name: Name,
    override val position: Position = Position()
) : Car {
    override fun move(factor: MoveFactor) {
        if (factor.isBiggerThanOrEquals(MOVE_THRESHOLD)) {
            position.increase(DEFAULT_SPEED)
        }
    }
}

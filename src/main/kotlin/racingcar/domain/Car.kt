package racingcar.domain

import racingcar.domain.strategy.DrivingRuleStrategy

class Car(
    private val drivingRuleStrategy: DrivingRuleStrategy,
    val position: Position = Position(),
) {
    fun drive(carSpeed: Int): Position {
        if (drivingRuleStrategy.canDrive(carSpeed)) {
            return position.change()
        }
        return position
    }
}

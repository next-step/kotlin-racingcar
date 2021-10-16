package racingcar.domain

import racingcar.domain.strategy.DrivingRuleStrategy
import java.util.concurrent.ThreadLocalRandom

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

    fun speedUp(): Int {
        return ThreadLocalRandom.current().nextInt(0, 9)
    }
}

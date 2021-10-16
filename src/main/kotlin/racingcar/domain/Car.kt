package racingcar.domain

import racingcar.domain.strategy.DrivingRuleStrategy
import java.util.concurrent.ThreadLocalRandom

class Car(
    private val drivingRuleStrategy: DrivingRuleStrategy,
    val position: Position = Position(),
) {
    fun drive(carSpeed: Int): Car {
        if (drivingRuleStrategy.canDrive(carSpeed)) {
            return Car(drivingRuleStrategy, position.change())
        }
        return this
    }

    fun speedUp(): Int {
        return ThreadLocalRandom.current().nextInt(0, 9)
    }
}

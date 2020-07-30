package step3.racing.rule

import step3.racing.car.Car

interface CarMovementRule {
    val rule: () -> Boolean

    fun moveCarByRule(car: Car): Car {
        return car.moveIf(rule)
    }
}

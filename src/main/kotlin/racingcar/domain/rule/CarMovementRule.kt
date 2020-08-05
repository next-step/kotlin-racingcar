package racingcar.domain.rule

import racingcar.domain.car.Car

interface CarMovementRule {
    val rule: () -> Boolean

    fun moveCarByRule(car: Car): Car {
        return car.moveIf(rule)
    }
}

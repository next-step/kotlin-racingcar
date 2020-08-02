package racingcar.racing.rule

import racingcar.racing.car.Car

interface CarMovementRule {
    val rule: () -> Boolean

    fun moveCarByRule(car: Car): Car {
        return car.moveIf(rule)
    }
}

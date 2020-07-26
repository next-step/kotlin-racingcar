package step3.car.rule

import step3.car.Car

interface CarMovementRule {
    val rule: () -> Boolean

    fun moveCarByRule(car: Car) {
        if (rule()) car.move()
    }
}

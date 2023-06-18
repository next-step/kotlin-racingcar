package study.racing.car

import study.racing.movement.condition.MovementCondition

class Car(
    val name: String,
    totalMoved: Int = 0
) {
    var totalMoved = totalMoved
        private set

    fun move(movementCondition: MovementCondition) {
        totalMoved += movementCondition.drive()
    }
}

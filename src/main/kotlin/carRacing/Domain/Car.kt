package carRacing.Domain

import carRacing.Service.MovementController

class Car(private val movementController: MovementController, position: Int = 0) {
    var position: Int = position
        private set(value) {
            if (value > 0) {
                field = value
            }
        }

    fun move() {
        if (movementController.isMove()) {
            position++
        }
    }
}

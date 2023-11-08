package carRacing.domain

import carRacing.service.MovementController

class Car(val name: String, val movementController: MovementController, position: Int = 1) {
    var position: Int = position
        private set

    fun move() {
        if (movementController.isMove()) {
            position++
        }
    }

    fun getPosition(): String = "-".repeat(position)

    fun copy(): Car = Car(this.name, this.movementController, this.position)
}

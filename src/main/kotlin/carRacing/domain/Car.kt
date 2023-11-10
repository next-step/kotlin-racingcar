package carRacing.domain

import carRacing.service.MovementController

class Car(val name: String, val movementController: MovementController, position: Int = 1) {
    var position: Int = position
        private set

    init {
        require(name.length in 1..5) { "자동차 이름은 1자 이상 5자 이하만 가능합니다." }
    }

    fun move() {
        if (movementController.isMove()) {
            position++
        }
    }

    fun getPosition(): String = "-".repeat(position)

    fun copy(): Car = Car(this.name, this.movementController, this.position)
}

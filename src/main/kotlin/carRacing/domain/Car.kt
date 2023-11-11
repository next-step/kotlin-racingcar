package carRacing.domain

import carRacing.service.MovementController

data class Car(val name: String, val movementController: MovementController, val position: Int = 1) {

    init {
        require(name.length in 1..5) { "자동차 이름은 1자 이상 5자 이하만 가능합니다." }
    }

    fun move(): Car {
        if (this.movementController.isMove()) {
            return Car(this.name, this.movementController, this.position + 1)
        }

        return this.copy()
    }
}

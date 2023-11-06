package carRacing.view

import carRacing.service.MovementController

data class CarInfo(val name: String, val movementController: MovementController) {

    init {
        require(name.length in 1..5) { "자동차 이름은 1자 이상 5자 이하만 가능합니다." }
    }
}

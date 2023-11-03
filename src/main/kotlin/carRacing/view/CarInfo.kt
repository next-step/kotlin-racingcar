package carRacing.view

import carRacing.service.MovementController

data class CarInfo(val name: String, private val _movementController: MovementController? = null) {
    var movementController: MovementController? = _movementController
        get() = field ?: throw IllegalStateException("MovementController가 null입니다.")
        set(value) {
            if (field != null) {
                throw IllegalStateException("MovementController가 이미 설정되었습니다.")
            }

            field = value
        }

    init {
        require(name.length in 1..5) { "자동차 이름은 1자 이상 5자 이하만 가능합니다." }
    }

    fun isChangeableMovementController(): Boolean = _movementController == null
}
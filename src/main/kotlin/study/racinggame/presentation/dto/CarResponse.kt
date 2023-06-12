package study.racinggame.presentation.dto

import study.racinggame.domain.Car

data class CarResponse(
    val position: Int = DEFAULT_POSITION,
    val name: String
) {

    fun getPositionRepresentation(): String {
        val positionRepresentation = POSITION_REPRESENT.repeat(position)
        return "$name : $positionRepresentation"
    }

    companion object {
        fun of(car: Car): CarResponse {
            return CarResponse(car.position, car.name)
        }
        private const val DEFAULT_POSITION: Int = 1
        private const val POSITION_REPRESENT: String = "-"
    }
}

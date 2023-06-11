package study.racinggame.presentation.dto

import study.racinggame.domain.Car

data class CarResponse(
    val position: Int = 1,
    val name: String
) {

    fun getPositionRepresentation(): String {
        val positionRepresentation = "-".repeat(position)
        return "$name : $positionRepresentation"
    }

    companion object {
        fun of(car: Car): CarResponse {
            return CarResponse(car.position(), car.name)
        }
    }
}

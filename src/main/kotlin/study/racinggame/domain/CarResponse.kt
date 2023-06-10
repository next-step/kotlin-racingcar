package study.racinggame.domain

data class CarResponse(
    val position: Int = 0,
    val name: String
) {

    fun getPositionRepresentation(): String {
        val positionRepresentation = "-".repeat(position)
        return "$name : $positionRepresentation"
    }

    companion object {
        fun of(car: Car): CarResponse {
            return CarResponse(car.position())
        }
    }
}

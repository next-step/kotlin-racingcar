package study.racinggame.domain

data class CarResponse(
    val position: Int = 0
) {
    fun getPositionRepresentation(): String {
        return "-".repeat(position)
    }

    companion object {
        fun of(car: Car): CarResponse {
            return CarResponse(car.position())
        }
    }
}

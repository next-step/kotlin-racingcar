package study.racinggame.domain

data class CarResponse(
    val position: Int = 0
) {
    fun getPositionRepresentation(): String {
        return "-".repeat(position)
    }
}

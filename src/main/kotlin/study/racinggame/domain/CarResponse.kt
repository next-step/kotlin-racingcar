package study.racinggame.domain

data class CarResponse(
    var position: Int = 0,
) {
    fun getPositionRepresentation(): String {
        return "-".repeat(position)
    }
}

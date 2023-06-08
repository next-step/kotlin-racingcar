package study.step3.domain

data class CarResponse(
    var position: Int = 0,
) {
    fun getPositionRepresentation(): String {
        return "-".repeat(position)
    }
}

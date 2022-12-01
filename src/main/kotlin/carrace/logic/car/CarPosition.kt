package carrace.logic.car

data class CarPosition(
    val position: Int = 0
) {
    fun move(movingDistance: Int): CarPosition {
        return CarPosition(position + movingDistance)
    }
}

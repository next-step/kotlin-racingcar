package game

object CarPositionRenderer {

    private const val POSITION_MARKER = "-"

    fun makePosition(car: Car) = POSITION_MARKER.repeat(car.position)
}

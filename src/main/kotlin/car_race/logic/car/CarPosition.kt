package car_race.logic.car

data class CarPosition(
    private val value: Int = 0
) {
    fun getValue() = value

    fun move(movingDistance: Int): CarPosition {
        return CarPosition(value + movingDistance)
    }
}

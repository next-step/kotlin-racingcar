package racingCar.domain

class Car(
    private val carMover: CarMovable,
    val name: String="",
    initialPosition: Int = 0
) {
    var position: Int = initialPosition
        private set

    fun move() {
        if (carMover.movable()) {
            this.position += DISTANCE
        }
    }

    companion object {
        private const val DISTANCE = 1
    }
}
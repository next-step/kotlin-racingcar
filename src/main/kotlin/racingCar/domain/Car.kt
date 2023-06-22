package racingCar.domain

class Car(
    private val carMover: CarMovable,
    val name: String="",
    var position: Int = 0
) {
    fun move() {
        if (carMover.movable()) {
            this.position += DISTANCE
        }
    }

    companion object {
        private const val DISTANCE = 1
    }
}
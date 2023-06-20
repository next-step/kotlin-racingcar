package step3

class Car(
    private val carMover: CarMover
) {
    var position: Int = 0

    fun move() {
        if (carMover.movable()) {
            this.position += DISTANCE
        }
    }

    companion object {
        private const val DISTANCE = 1
    }
}
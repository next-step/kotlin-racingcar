package step3.domain

class Car(
    private val carMover: CarMover,
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
package racing.car

class Car(position: Int = START_POSITION, val name: String = "kotlin") {
    var position: Int = position
        private set
    fun moveForward(forwardSteps: Int) {
        if (forwardSteps >= FORWARD_THRESHOLD) {
            this.position += 1
        }
    }

    companion object {
        private const val START_POSITION = 1
        private const val FORWARD_THRESHOLD = 4
    }
}

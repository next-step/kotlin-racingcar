package racing.car

class Car(position: Int = START_POSITION, val name: String = "kotlin") {
    var position: Int = position
        private set
    fun moveForward(forwardSteps: Int) {
        if (forwardSteps >= 4) {
            this.position += 1
        }
    }

    companion object {
        const val START_POSITION = 1
    }
}

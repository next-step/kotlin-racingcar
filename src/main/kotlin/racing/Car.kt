package racing

class Car(private var position: Int = START_POSITION) {

    companion object {
        const val START_POSITION = 1
    }

    val currentPosition: Int
        get() = position

    fun moveForward(forwardSteps: Int) {
        if (forwardSteps >= 4) {
            position += 1
        }
    }
}

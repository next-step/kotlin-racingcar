package racing

class Car(private val moveThreshold: Int = DEFAULT_CAR_MOVE_THRESHOLD) {
    var position = 0
        private set

    fun move(power: Int) {
        if (power >= moveThreshold) position++
    }

    companion object {
        private const val DEFAULT_CAR_MOVE_THRESHOLD = 4
    }
}

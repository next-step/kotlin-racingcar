package racing

class Car(
    val name: String,
    private val moveThreshold: Int = DEFAULT_CAR_MOVE_THRESHOLD,
    startPosition: Int = 0
) {

    var position = startPosition
        private set

    fun move(power: Int) {
        if (power >= moveThreshold) position++
    }

    companion object {
        private const val DEFAULT_CAR_MOVE_THRESHOLD = 4
    }
}

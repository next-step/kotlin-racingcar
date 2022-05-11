package racing

class Car(
    val name: String,
    private val powerStrategy: PowerStrategy = ZeroPowerStrategy,
    private val moveThreshold: Int = DEFAULT_CAR_MOVE_THRESHOLD,
    startPosition: Int = 0
) {

    var position = startPosition
        private set

    fun move() {
        if (powerStrategy.getPower() >= moveThreshold) position++
    }

    companion object {
        private const val DEFAULT_CAR_MOVE_THRESHOLD = 4
    }
}

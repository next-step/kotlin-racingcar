package racing.model

class Car(
    val name: String,
    private val engine: Engine,
) {
    var position: Int
        private set

    init {
        position = DEFAULT_CAR_START_POSITION
        CarValidator.validateNameLength(name)
    }

    fun move() {
        if (engine.canMoveForward()) {
            position++
        }
    }

    companion object {
        const val DEFAULT_CAR_START_POSITION = 0
        const val DEFAULT_FORWARD_LIMIT = 4
        const val MAX_NAME_LENGTH = 5
    }
}

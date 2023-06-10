package step3.domain

class Car(option: CarOption = CarOption()) {
    private var _position = option.position
    private val moveForwardCondition = option.moveForwardCondition

    val position: Int
        get() = _position

    fun moveForwardRandomly() {
        if (moveForwardCondition()) _position += MOVE_FORWARD_VALUE
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_FORWARD_VALUE = 1
        private const val THRESHOLD_OF_MOVABLE = 4
        private val RANGE = (0..9)
    }

    class CarOption(
        val position: Int = INIT_POSITION,
        val moveForwardCondition: () -> Boolean = { RANGE.random() >= THRESHOLD_OF_MOVABLE },
    )
}

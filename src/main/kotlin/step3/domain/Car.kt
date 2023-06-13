package step3.domain

class Car(
    val name: String,
    private var _position: Int = INIT_POSITION,
    private val condition: MoveCondition = CarMoveCondition()
) {

    fun move() {
        if (condition.isMovable()) {
            _position += MOVING_STEP
        }
    }

    val position get() = _position

    companion object {
        const val INIT_POSITION = 1
        const val MOVING_STEP = 1
    }
}

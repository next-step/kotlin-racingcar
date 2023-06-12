package step3.domain

class Car(
    val name: String,
    private var position: Int = INIT_POSITION,
    private val condition: MoveCondition = CarMoveCondition()
) {

    fun move() {
        if (condition.isMovable()) {
            position += 1
        }
    }

    fun getPosition(): Int {
        return position
    }

    companion object {
        const val INIT_POSITION = 1
    }
}

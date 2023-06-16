package step3.domain

class Car(
    val name: String,
    position: Int = DEFAULT_POSITION,
    private val condition: MoveCondition = CarMoveCondition()
) {
    init {
        require(name.length <= 5) { "자동차의 이름은 5글자를 넘을 수 없습니다." }
    }

    var position: Int = position
        private set

    fun move() {
        if (condition.isMovable()) {
            position += MOVING_STEP
        }
    }

    companion object {
        const val DEFAULT_POSITION = 0
        const val MOVING_STEP = 1
    }
}

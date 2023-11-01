package racing.domain

private const val MAXIMUM_NAME_LENGTH = 5
private const val DEFAULT_POSITION = 1
private const val MOVABLE_MINIMUM = 4
private const val MOVING_DISTANCE = 1

data class Car(val name: String, private var _position: Int = DEFAULT_POSITION) {
    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    val position: Int
        get() = _position

    fun moveOrStop(random: Int) {
        if (isMove(random)) {
            move()
        }
    }

    private fun isMove(random: Int): Boolean = random >= MOVABLE_MINIMUM

    private fun move() {
        _position += MOVING_DISTANCE
    }
}

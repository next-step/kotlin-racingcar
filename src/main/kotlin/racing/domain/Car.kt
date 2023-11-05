package racing.domain

private const val MAXIMUM_NAME_LENGTH = 5
private const val DEFAULT_POSITION = 1
private const val MOVABLE_MINIMUM = 4
private const val MOVING_DISTANCE = 1

class Car private constructor(
    val name: String,
    position: Int
) {

    var position: Int = position
        private set

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    fun moveOrStop(condition: Int) {
        if (isMove(condition)) {
            move()
        }
    }

    private fun isMove(condition: Int): Boolean = condition >= MOVABLE_MINIMUM

    private fun move() {
        position += MOVING_DISTANCE
    }

    companion object {
        fun of(name: String, position: Int = DEFAULT_POSITION): Car = Car(name, position)
    }
}

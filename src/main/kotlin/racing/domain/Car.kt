package racing.domain

class Car private constructor(
    private val condition: CarRacingCondition,
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

    fun moveOrStop() {
        if (condition.canMove()) {
            move()
        }
    }

    private fun move() {
        position += MOVING_DISTANCE
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH = 5
        private const val DEFAULT_POSITION = 1
        private const val MOVING_DISTANCE = 1

        fun of(
            condition: CarRacingCondition,
            name: String,
            position: Int = DEFAULT_POSITION,
        ): Car = Car(condition, name, position)
    }
}

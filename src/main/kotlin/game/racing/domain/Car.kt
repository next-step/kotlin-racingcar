package game.racing.domain

class Car(val name: String) {
    var position = MIN_POSITION
        private set

    init {
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) { NOT_VALID_CAR_NAME_MESSAGE }
    }

    fun moveOrStayBySpeed(speed: Int) {
        if (speed >= MIN_MOVE_THRESHOLD) {
            position++
        }
    }

    companion object {
        const val MIN_RANDOM_VALUE = 0
        const val MAX_RANDOM_VALUE = 9
        const val MIN_POSITION = 0
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_CAR_NAME_LENGTH = 1
        const val NOT_VALID_CAR_NAME_MESSAGE = "자동차 이름은 1글자 이상 5글자 이하만 가능합니다."
        const val MIN_MOVE_THRESHOLD = 4
    }
}

package racingcar

class Car(
    val name: String,
    moveCount: Int = 0,
) {
    var moveCount: Int = moveCount
        private set

    init {
        require(validateNameBlank(name)) { "자동차 이름은 공백일 수 없습니다." }
        require(validateNameLength(name)) { "자동차 이름 ${name}은 최대 길이(5자)를 초과합니다." }
    }

    fun move(number: Int) {
        if (number >= MOVE_MIN_CONDITION) {
            this.moveCount += MOVE_DISTANCE
        }
    }

    private fun validateNameBlank(name: String): Boolean {
        return name.isNotBlank()
    }

    private fun validateNameLength(name: String): Boolean {
        return name.length <= NAME_LIMIT_LENGTH
    }

    companion object {
        private const val MOVE_MIN_CONDITION = 4
        private const val MOVE_DISTANCE = 1
        private const val NAME_LIMIT_LENGTH = 5
    }
}

package racingcar.domain

private const val MAXIMUM_WORD_COUNT = 5
private const val DEFAULT_POSITION = 0

data class Car(val name: String, private var position: Int = DEFAULT_POSITION) : MoveStrategy() {

    init {
        validateName(name)
        validatePosition(position)
    }

    fun move(movable: Boolean = canMove()) {
        if (movable) {
            position += 1
        }
    }

    fun toState(): CarState {
        return CarState(name, position)
    }

    private fun validateName(name: String) {
        require(name.isNotBlank()) { "자동차 이름은 공백, 빈 문자열일 수 없습니다" }
        require(name.length <= MAXIMUM_WORD_COUNT) { "자동차 이름은 다섯자를 초과할 수 없습니다" }
    }

    private fun validatePosition(position: Int) {
        require(position >= 0) { "음수를 입력할 수 없습니다" }
    }
}

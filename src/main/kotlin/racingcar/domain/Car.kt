package racingcar.domain

class Car(position: Int = 0, val name: String) {
    var position: Int = position
        private set

    init {
        validateNameIsNotBlank()
        validateNameLength()
    }

    private fun validateNameIsNotBlank() {
        if (name.isBlank()) {
            throw IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.")
        }
    }

    private fun validateNameLength() {
        val nameLength = name.length
        if (nameLength > NAME_LENGTH_LIMIT) {
            throw IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다. 현재 입력 = $name, 글자 수 = $nameLength")
        }
    }

    fun moveOrStay(condition: Int) {
        if (canMove(condition)) {
            position++
        }
    }

    private fun canMove(condition: Int) = condition >= THRESHOLD

    companion object {
        private const val THRESHOLD = 4
        private const val NAME_LENGTH_LIMIT = 5
    }
}

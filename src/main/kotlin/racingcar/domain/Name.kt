package racingcar.domain

class Name(val value: String) {
    init {
        if (value.length > NAME_LENGTH_LIMIT) {
            throw IllegalArgumentException(VALIDATION_MESSAGE)
        }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
        private const val VALIDATION_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다."
    }
}

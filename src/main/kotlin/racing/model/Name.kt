package racing.model

data class Name(val name: String) {
    init {
        require(name.length <= MAX_NAME_LENGTH) { INVALID_CAR_NAME_LENGTH }
        require(name.isNotBlank()) { INVALID_CAR_NAME_BLANK }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        const val INVALID_CAR_NAME_LENGTH = "자동차의 이름은 5자를 초과할 수 없습니다."
        const val INVALID_CAR_NAME_BLANK = "자동차의 이름은 공백이 될 수 없습니다."
    }
}

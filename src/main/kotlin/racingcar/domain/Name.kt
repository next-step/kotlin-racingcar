package racingcar.domain

@JvmInline
value class Name(val value: String) {
    init {
        require(value.length <= 5) { ERROR_NAME_LENGTH }
    }

    companion object {
        private const val ERROR_NAME_LENGTH = "Name cannot exceed 5 characters"
    }
}

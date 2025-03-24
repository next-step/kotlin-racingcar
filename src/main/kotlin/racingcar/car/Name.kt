package racingcar.car

class Name(
    val value: String,
) {
    init {
        require(value.isNotBlank()) { "Name must not be blank." }
        require(value.length in MINIMUM_NAME_LENGTH..MAXIMUM_NAME_LENGTH) {
            "Name must be between 1 and 5 characters."
        }
    }

    companion object {
        private const val MINIMUM_NAME_LENGTH = 1
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}

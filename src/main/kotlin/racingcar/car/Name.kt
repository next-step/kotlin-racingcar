package racingcar.car

class Name(
    val value: String,
) {
    init {
        require(value.isNotBlank()) { "Name must not be blank." }
        require(value.length in MINIMUM_NAME_LENGTH..MAXIMUM_NAME_LENGTH) {
            "Name must have at least 1 to 5 characters."
        }
    }

    companion object {
        private const val MINIMUM_NAME_LENGTH = 1
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}

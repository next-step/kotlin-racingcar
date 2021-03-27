package racingcar.domain

data class Name(val value: String) {
    init {
        require(value.length in NAME_LENGTH_RANGE)
    }

    companion object {
        private const val MINIMUM_NAME_LENGTH = 1
        private const val MAXIMUM_NAME_LENGTH = 5
        private val NAME_LENGTH_RANGE = (MINIMUM_NAME_LENGTH..MAXIMUM_NAME_LENGTH)
    }
}

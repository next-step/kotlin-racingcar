package racingcar.domain

@JvmInline
value class Moving(val value: Int) {
    init {
        require(value >= 0) { ERROR_MINIMUM_VALUE }
    }

    companion object {
        private const val ERROR_MINIMUM_VALUE = "It should be more than 0"
    }
}

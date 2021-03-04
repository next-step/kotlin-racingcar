package racingcar.domain

data class Distance(val value: Int = DEFAULT_VALUE) {
    init {
        require(value >= DEFAULT_VALUE)
    }

    fun sum(distance: Distance): Distance {
        return copy(value = value + distance.value)
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}

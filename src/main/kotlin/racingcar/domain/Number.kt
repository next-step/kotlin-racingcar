package racingcar.domain

data class Number(val value: Int = MINIMUM_VALUE) {

    init {
        require(value in MINIMUM_VALUE..MAXIMUM_VALUE)
    }

    fun isOver(number: Number) = value >= number.value

    companion object {
        const val MINIMUM_VALUE = 0
        const val MAXIMUM_VALUE = 9
    }
}

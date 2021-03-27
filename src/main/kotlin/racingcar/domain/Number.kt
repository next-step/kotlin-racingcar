package racingcar.domain

data class Number(val value: Int = MINIMUM_VALUE) : Comparable<Number> {

    init {
        require(value in MINIMUM_VALUE..MAXIMUM_VALUE)
    }

    override fun compareTo(other: Number): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        const val MINIMUM_VALUE = 0
        const val MAXIMUM_VALUE = 9
    }
}

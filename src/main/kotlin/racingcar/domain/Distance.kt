package racingcar.domain

data class Distance(val value: Int = DEFAULT_VALUE) : Comparable<Distance> {
    init {
        require(value >= DEFAULT_VALUE)
    }

    operator fun plus(distance: Distance): Distance {
        return copy(value = value + distance.value)
    }

    override fun compareTo(other: Distance) = this.value.compareTo(other.value)

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}

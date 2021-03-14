package racingcar.domain.engine

data class Force(val value: Int) {
    init {
        require(value >= ZERO_VALUE) { "Force must be positive or zero." }
    }

    operator fun compareTo(other: Force): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        private const val ZERO_VALUE = 0
    }
}

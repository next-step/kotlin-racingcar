package racingcar

data class Force(val value: Int) {
    companion object {
        val ZERO = Force(0)
    }

    operator fun compareTo(other: Force): Int {
        return this.value - other.value
    }
}

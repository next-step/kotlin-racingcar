package racingcar

data class Force(val value: Int) {
    operator fun compareTo(other: Force): Int {
        return this.value - other.value
    }

    companion object {
        val ZERO = Force(0)
    }
}

package racingcar

data class Force(val value: Int) {
    operator fun compareTo(other: Force): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        val ZERO = Force(0)
    }
}

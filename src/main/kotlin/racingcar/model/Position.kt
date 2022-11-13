package racingcar.model

data class Position(private var value: NonNegative = NonNegative()) {

    constructor(input: String) : this() {
        this.value = NonNegative(input)
    }

    fun plus() {
        this.value.plus(FORWARD_VALUE)
    }

    fun getPosition(): Int {
        return this.value.getNonNegativeValue()
    }

    companion object {
        private const val FORWARD_VALUE = 1
    }

    operator fun compareTo(other: Position): Int =
        when {
            this.value > other.value -> 1
            this.value < other.value -> -1
            else -> 0
        }
}

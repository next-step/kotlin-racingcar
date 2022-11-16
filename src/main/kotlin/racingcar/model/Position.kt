package racingcar.model

data class Position(private val value: PositiveNumber = PositiveNumber()) {

    constructor(input: String) : this(PositiveNumber(input))

    fun plus() {
        this.value.plus(FORWARD_VALUE)
    }

    fun getPosition(): Int {
        return this.value.getPositiveNumber()
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

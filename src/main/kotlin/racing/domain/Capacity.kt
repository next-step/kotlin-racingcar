package racing.domain

@JvmInline
value class Capacity(val value: Int) : Comparable<Capacity> {
    constructor(value: String?) : this(
        value?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid value: $value required number formattable value")
    )

    init {
        require(value >= 0) {
            "$INVALID_CAPACITY_MESSAGE $value"
        }
    }

    val availableRange: IntRange get() = 0 until value

    override fun compareTo(other: Capacity): Int = value compareTo other.value

    companion object {
        const val INVALID_CAPACITY_MESSAGE = "Required positive number. Invalid value:"

        val ZERO = Capacity(0)
    }
}

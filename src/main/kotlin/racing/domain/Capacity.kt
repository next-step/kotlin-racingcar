package racing.domain

@JvmInline
value class Capacity(val value: Int) : Iterable<Int>, Comparable<Capacity> {
    constructor(value: String?) : this(
        value?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid value: $value required number formattable value")
    )

    init {
        require(value >= 0) {
            "Invalid value: $value required positive number"
        }
    }

    override fun iterator(): Iterator<Int> = (0 until value).iterator()

    override fun compareTo(other: Capacity): Int = value.compareTo(other.value)

    companion object {
        val ZERO = Capacity(0)
    }
}

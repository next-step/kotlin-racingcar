package racing.domain

@JvmInline
value class Capacity(val value: Int) : Iterable<Int> {
    constructor(value: String?) : this(
        value?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid value: $value required number formattable value")
    )

    init {
        require(value >= 0) {
            "Invalid value: $value required number formattable value"
        }
    }

    override fun iterator(): Iterator<Int> {
        return (0..value).iterator()
    }
}

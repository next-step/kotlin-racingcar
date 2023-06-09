package racing.domain

@JvmInline
value class Distance(private val value: Long) : Comparable<Distance> {
    operator fun plus(target: Distance): Distance = Distance(value + target.value)

    override operator fun compareTo(other: Distance): Int = value.compareTo(other.value)

    val getValue
        get() = value

    companion object {
        val ZERO = Distance(0L)
    }
}

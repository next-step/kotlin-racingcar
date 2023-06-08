package racing.domain

@JvmInline
value class Distance(private val value: Long) {
    operator fun plus(target: Distance): Distance = Distance(value + target.value)

    companion object {
        val ZERO = Distance(0L)
    }
}

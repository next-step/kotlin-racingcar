package racing.model

@JvmInline
value class Position private constructor(
    val position: Int
) {

    fun plusOne() = Position(position + 1)

    companion object {
        private const val MIN_POSITION = 0

        fun from(position: Int) = Position(position.coerceAtLeast(MIN_POSITION))
    }
}

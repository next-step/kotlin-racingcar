package domain.racing

@JvmInline
value class Position(val position: Int) {

    fun move(): Position {
        return Position(position + 1)
    }

    companion object {
        private const val ZERO_POSITION = 0

        @JvmStatic
        fun create(): Position {
            return Position(ZERO_POSITION)
        }
    }
}

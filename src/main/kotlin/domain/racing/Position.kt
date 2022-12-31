package domain.racing

data class Position(var position: Int) {

    fun move() {
        position++
    }

    companion object {
        private const val ZERO_POSITION = 0

        @JvmStatic
        fun create(): Position {
            return Position(ZERO_POSITION)
        }
    }
}

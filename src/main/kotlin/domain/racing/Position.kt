package domain.racing

class Position(var position: Int) {

    companion object {

        private const val ZERO_POSITION = 0

        @JvmStatic
        fun create(): Position {
            return Position(ZERO_POSITION)
        }
    }

    fun move() {
        position++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position
    }
}

package step3.domain.car

class Position(
    private val position: Int = 0
) {
    fun forward() = Position(this.position + 1)

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

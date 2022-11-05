package step3.domain.car

class Position(
    private var position: Int = 0
) {
    fun forward() {
        this.position++
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

package racing.domain

class Car(
    private var position: Int = 0
) {

    fun move(movable: Boolean) {
        if (movable) {
            position++
        }
    }

    fun samePosition(position: Int): Boolean = this.position == position

    fun getPosition(): Int = this.position

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position
    }
}

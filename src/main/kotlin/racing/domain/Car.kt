package racing.domain

class Car(
    private var position: Int = 0
) {

    fun samePosition(position: Int): Boolean {
        return this.position == position
    }

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

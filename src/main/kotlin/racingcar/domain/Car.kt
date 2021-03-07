package racingcar.domain

class Car(
    private var position: NamedPosition = NamedPosition.Smart(),
    private val moveable: Moveable = Moveable.Random()
) {
    fun driving(): NamedPosition {
        if (moveable.moving()) {
            position++
        }
        return position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position.hashCode()
    }
}

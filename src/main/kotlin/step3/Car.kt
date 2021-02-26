package step3

class Car(private var position: Position = Position(0), private val moveable: Moveable = Moveable.Random()) {
    fun driving(): Position {
        if (moveable.moving()) {
            position = position.increase()
        }
        return position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

package racing.model

class Car private constructor(
    private val name: Name,
    private val position: Position = Position(0)
) {

    fun moveForward(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position.plusOne()
        }
    }

    fun position(): Int {
        return position.position
    }

    fun name(): String {
        return name.name
    }

    companion object {
        fun of(name: String): Car {
            return Car(Name(name))
        }

        fun of(name: String, position: Int): Car {
            return Car(Name(name), Position(position))
        }
    }
}

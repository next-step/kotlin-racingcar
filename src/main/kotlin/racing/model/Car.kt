package racing.model

class Car private constructor(
    private val name: Name,
    private val position: Position = Position.from(DEFAULT_POSITION)
) {

    fun moveForward(movingStrategy: MovingStrategy): Car {
        if (movingStrategy.isMovable()) {
            return Car(Name(name()), position.plusOne())
        }
        return Car(Name(name()), Position.from(position()))
    }

    fun position(): Int {
        return position.position
    }

    fun name(): String {
        return name.toString()
    }

    companion object {
        private const val DEFAULT_POSITION = 0

        fun from(name: String): Car {
            return Car(Name(name))
        }

        fun of(name: String, position: Int): Car {
            return Car(Name(name), Position.from(position))
        }
    }
}

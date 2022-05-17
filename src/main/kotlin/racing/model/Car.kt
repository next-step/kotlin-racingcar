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

    fun position() = position.position

    fun name() = name.toString()

    companion object {
        private const val DEFAULT_POSITION = 0

        fun from(name: String) = Car(Name(name))

        fun of(name: String, position: Int) = Car(Name(name), Position.from(position))
    }
}

package racingcar.model

private const val MOVE_THRESHOLD = 4
private const val DEFAULT_SPEED = 1

class Car(
    val name: Name,
    val position: Position = Position()
) {
    fun move(factor: MoveFactor) {
        if (factor.isBiggerThanOrEquals(MOVE_THRESHOLD)) {
            position.increase(DEFAULT_SPEED)
        }
    }

    companion object {
        fun of(name: String) = Car(Name(name))
        fun of(name: String, position: Int) = Car(Name(name), Position(position))
    }
}

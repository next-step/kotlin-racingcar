package racingcar.model

private const val NAME_LENGTH_LIMIT = 5
private const val MOVE_THRESHOLD = 4
private const val DEFAULT_SPEED = 1

class Car(val name: String = "-", val position: Position = Position()) {

    init {
        require(name.isNotBlank())
        require(name.length <= NAME_LENGTH_LIMIT)
    }

    fun move(factor: MoveFactor) {
        if (factor.isBiggerThanOrEquals(MOVE_THRESHOLD)) {
            position.increase(DEFAULT_SPEED)
        }
    }
}

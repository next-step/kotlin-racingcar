package racingcar.car

class Car(
    position: Int = START_POSITION,
    private val carName: Name,
    private val canMove: () -> Boolean = randomCanMove,
) {
    var position: Int = position
        private set

    val name: String
        get() = carName.value

    constructor(name: String) : this(
        carName = Name(name),
    )

    constructor(name: String, canMove: () -> Boolean) : this(
        carName = Name(name),
        canMove = canMove,
    )

    fun move() {
        if (canMove()) {
            position++
        }
    }

    companion object {
        private const val MINIMUM_POWER = 1
        private const val MAXIMUM_POWER = 9
        private const val START_POSITION = 0
        private const val ENGINE_THRESHOLD = 4

        private val randomCanMove: () -> Boolean = {
            (MINIMUM_POWER..MAXIMUM_POWER).random() >= ENGINE_THRESHOLD
        }
    }
}

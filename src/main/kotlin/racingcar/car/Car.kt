package racingcar.car

class Car(
    val name: Name,
    var position: Int = START_POSITION,
    private val canMove: () -> Boolean = {
        (MINIMUM_POWER..MAXIMUM_POWER).random() >= ENGINE_THRESHOLD
    },
) {
    constructor(name: String) : this(
        name = Name(name),
    )

    constructor(name: String, canMove: () -> Boolean) : this(
        name = Name(name),
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
    }
}

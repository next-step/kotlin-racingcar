package racingcar.car

class Car(
    val name: String,
    var position: Int = START_POSITION,
    private val canMove: () -> Boolean = {
        (MINIMUM_POWER..MAXIMUM_POWER).random() >= ENGINE_THRESHOLD
    },
) {
    init {
        require(name.isNotBlank()) { "Car name must not be blank." }
        require(name.length in MINIMUM_CAR_NAME_LENGTH..MAXIMUM_CAR_NAME_LENGTH) {
            "Car name must have at least 1 to 5 characters."
        }
    }

    fun move() {
        if (canMove()) {
            position++
        }
    }

    companion object {
        private const val MINIMUM_CAR_NAME_LENGTH = 1
        private const val MAXIMUM_CAR_NAME_LENGTH = 5
        private const val MINIMUM_POWER = 1
        private const val MAXIMUM_POWER = 9
        private const val START_POSITION = 0
        private const val ENGINE_THRESHOLD = 4
    }
}

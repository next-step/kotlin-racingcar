package step4.domain

class Car(
    val name: String,
    val moveForwardCondition: () -> Boolean = { RANGE_FOR_MOVING_CONDITION.random() >= THRESHOLD_OF_MOVABLE },
) {
    var position: Int = INIT_POSITION
        private set

    init {
        require(name.length in RANGE_FOR_NAME_LENGTH) { "자동차 이름은 1자 이상, 5자 이하만 가능합니다." }
    }

    fun moveForwardRandomly() {
        if (moveForwardCondition()) position += MOVE_FORWARD_VALUE
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_FORWARD_VALUE = 1
        private const val THRESHOLD_OF_MOVABLE = 4
        private val RANGE_FOR_MOVING_CONDITION = (0..9)
        private val RANGE_FOR_NAME_LENGTH = (1..5)
    }
}

class CarDto(
    val name: String,
    val position: Int,
) {
    companion object {
        fun of(car: Car): CarDto = CarDto(car.name, car.position)
    }
}

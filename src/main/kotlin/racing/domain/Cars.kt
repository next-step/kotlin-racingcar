package racing.domain

private const val MINIMUM_COUNT_OF_CARS = 2

private const val DELIMITER_OF_NAME = ","

class Cars(private val value: List<Car>) {

    init {
        require(value.size >= MINIMUM_COUNT_OF_CARS) {
            "자동차는 최소 ${MINIMUM_COUNT_OF_CARS}대 이상이어야 합니다."
        }
    }

    companion object {
        fun create(names: String): Cars {
            return Cars(names.trim().split(DELIMITER_OF_NAME).map { Car.from(it.trim()) })
        }
    }

    fun move(movable: Movable) {
        value.forEach {
            it.move(movable.canMoveIt())
        }
    }

    fun value(): List<Car> {
        return value.map { it.copy() }
    }
}

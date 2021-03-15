package race.domain

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.isNotBlank()) { "name is not blank." }
        require(name.length <= NAME_LENGTH) { "name's length is lesser than or equals to $NAME_LENGTH."}
    }

    fun move(condition: Int): Car {
        if (condition !in MOVE_START_RANGE..MOVE_END_RANGE) {
            throw IllegalArgumentException("condition is between 0 and 9.")
        }

        if (isMove(condition)) {
            position++
        }

        return this
    }

    private fun isMove(condition: Int) = condition >= MOVE_CONDITION

    companion object {
        const val MOVE_START_RANGE = 0
        const val MOVE_END_RANGE = 9
        const val MOVE_CONDITION = 4

        const val NAME_LENGTH = 5
        const val NAME_DELIMETER: String = ","

        fun create(carNames: String): List<Car> {
            require(carNames.isNotBlank()) { "carNames is not blank." }
            return carNames.split(NAME_DELIMETER).map { Car(it) }
        }
    }
}

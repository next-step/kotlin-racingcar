package racingcar.domain.car
import racingcar.exception.InvalidCarNameLengthInput

class Car(
    val name: CarName
) {
    private var distance: Int = 0

    init {
        if (name.length > CAR_NAME_LENGTH_LIMIT) {
            throw InvalidCarNameLengthInput()
        }
    }

    fun move(assignedNumber: Int? = null): Int {
        val number = assignedNumber ?: getRandomNumber()
        if (number >= CAR_MOVE_MINIMUM_THRESHOLD) {
            distance += 1
        }
        return distance
    }

    private fun getRandomNumber() = numberRange.random()

    companion object {
        private const val CAR_NAME_LENGTH_LIMIT = 5
        private const val CAR_MOVE_MINIMUM_THRESHOLD = 4
        private val numberRange = (0..9)
    }
}

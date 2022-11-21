package racingcar.domain.car
import racingcar.exception.InvalidCarNameLengthInput

class Car(
    val name: CarName
) {
    private var distance: Int = 0

    init {
        if (name.length > 5) {
            throw InvalidCarNameLengthInput()
        }
    }

    fun move(assignedNumber: Int? = null): Int {
        val number = assignedNumber ?: getRandomNumber()
        if (number >= 4) {
            distance += 1
        }
        return distance
    }

    fun getRandomNumber() = numberRange.random()

    companion object {
        private val numberRange = (0..9)
    }
}

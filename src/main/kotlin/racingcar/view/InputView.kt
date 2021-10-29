package racingcar.view

import common.ErrorMessage.FORWARD_ATTEMPTS_NUMBERS
import common.ErrorMessage.NOT_NULL_AND_EMPTY
import common.ErrorMessage.ONLY_NUMBERS
import common.ErrorMessage.REGISTER_CARS_COUNT

class InputView(private val value: String? = readLine()) {

    init {
        require(value!!.isNotBlank()) {
            throw IllegalArgumentException(NOT_NULL_AND_EMPTY)
        }

        require(VERIFY_NUMBERS.matches(value)) {
            throw IllegalArgumentException(ONLY_NUMBERS)
        }
    }

    fun inputNumberOfMoves(): Int {
        writePrint(REGISTER_CARS_COUNT)
        return valueToInt()
    }

    fun inputNumberOfNewCars(): Int {
        writePrint(FORWARD_ATTEMPTS_NUMBERS)
        return valueToInt()
    }

    private fun valueToInt() = value!!.toInt()
    private fun writePrint(inputString: String) = println(inputString)

    companion object {
        private val VERIFY_NUMBERS = "^[0-9]*$".toRegex()
    }
}

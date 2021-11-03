package racingcar.view

import common.ErrorMessage.FORWARD_ATTEMPTS_NUMBERS
import common.ErrorMessage.NOT_NULL_AND_EMPTY
import common.ErrorMessage.ONLY_NUMBERS
import common.ErrorMessage.REGISTER_CARS_COUNT

object InputView {
    private val VERIFY_NUMBERS = "^[0-9]*$".toRegex()

    fun numberOfMoves(): Int {
        writePrint(REGISTER_CARS_COUNT)
        return inputNumberOfMoves()
    }

    fun numberOfNewCars(): Int {
        writePrint(FORWARD_ATTEMPTS_NUMBERS)
        return inputNumberOfNewCars()
    }

    fun inputNumberOfMoves(value: String = readLine()!!): Int {
        return verificationInputValueAndToInt(value)
    }

    fun inputNumberOfNewCars(value: String = readLine()!!): Int {
        return verificationInputValueAndToInt(value)
    }

    private fun writePrint(inputString: String) = println(inputString)

    private fun verificationInputValueAndToInt(inputNumber: String): Int {
        require(inputNumber.isNotBlank()) {
            throw IllegalArgumentException(NOT_NULL_AND_EMPTY)
        }

        require(VERIFY_NUMBERS.matches(inputNumber)) {
            throw IllegalArgumentException(ONLY_NUMBERS)
        }

        return inputNumber.toInt()
    }
}

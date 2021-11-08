package racingcar.view

import common.ErrorMessage.FORWARD_ATTEMPTS_NUMBERS
import common.ErrorMessage.NOT_NULL_AND_EMPTY
import common.ErrorMessage.ONLY_NUMBERS
import common.ErrorMessage.REGISTER_CARS_COUNT

object InputView {
    private val VERIFY_NUMBERS = "^[0-9]*$".toRegex()

    fun numberOfMoves(): Int {
        println(REGISTER_CARS_COUNT)
        return inputNumberOfMoves()
    }

    fun nameOfNewCars(): String {
        println(FORWARD_ATTEMPTS_NUMBERS)
        return inputCarsName()
    }

    fun inputNumberOfMoves(value: String = readLine()!!): Int {
        return verificationInputValueAndToInt(value)
    }

    fun inputCarsName(value: String = readLine()!!): String {
        return verificationInputValue(value)
    }

    private fun verificationInputValue(inputString: String): String {
        confirmIsNotBlank(inputString)
        return inputString
    }

    private fun verificationInputValueAndToInt(inputNumber: String): Int {
        confirmIsNotBlank(inputNumber)

        require(VERIFY_NUMBERS.matches(inputNumber)) {
            throw IllegalArgumentException(ONLY_NUMBERS)
        }

        return inputNumber.toInt()
    }

    private fun confirmIsNotBlank(inputNumber: String) {
        require(inputNumber.isNotBlank()) {
            throw IllegalArgumentException(NOT_NULL_AND_EMPTY)
        }
    }
}

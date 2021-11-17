package racingcar.view

import common.ErrorMessage.NOT_NULL_AND_EMPTY
import common.ErrorMessage.ONLY_NUMBERS

object InputView {

    private const val REGISTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"
    private const val FORWARD_ATTEMPTS_NUMBERS = "시도할 횟수는 몇 회인가요?"
    private val VERIFY_NUMBERS = "^[0-9]*$".toRegex()

    fun numberOfMoves(): Int {
        println(FORWARD_ATTEMPTS_NUMBERS)
        return inputNumberOfMoves()
    }

    fun nameOfNewCars(): String {
        println(REGISTER_CAR_NAMES)
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

package racingCar.lib

import racingCar.constants.Messages.INPUT_NOT_NUMBER

class Validation {

    fun isNumber(inputString: String): Int {
        inputString.forEach { charOfString: Char ->
            if (!charOfString.isDigit()) throw IllegalArgumentException(INPUT_NOT_NUMBER)
        }
        return inputString.toInt()
    }
}
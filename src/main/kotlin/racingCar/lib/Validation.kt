package racingCar.lib

import racingCar.constants.Messages.INPUT_NOT_NUMBER

class Validation {

    fun isNumber(input: String): Int {
        input.forEach { charOfString: Char ->
            if (!charOfString.isDigit()) throw IllegalArgumentException(INPUT_NOT_NUMBER)
        }
        return input.toInt()
    }
}
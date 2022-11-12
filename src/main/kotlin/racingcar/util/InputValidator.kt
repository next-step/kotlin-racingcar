package racingcar.util

import racingcar.const.CarException
import racingcar.extension.isNumeric

object InputValidator {
    fun validateCarNameStr(input: String?) {
        require(input != null) { CarException.NULL_INPUT_ERROR }
        require(input.length <= 5) { CarException.MORE_THAN_FIVE_WORD_ERROR }
    }

    fun validateNumberOfTryStr(input: String?) {
        require(input != null) { CarException.NULL_INPUT_ERROR }
        require(input.isNumeric()) { CarException.NOT_DIGIT_ERROR }
        require(input.toInt() > 0) { CarException.MORE_THAN_ONE }
    }

    fun validateParserStr(input: String?) {
        // TODO
    }
}
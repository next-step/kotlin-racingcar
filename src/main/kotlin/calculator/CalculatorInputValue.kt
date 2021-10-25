package calculator

import common.Constant.SPACING
import common.ErrorMessage

class CalculatorInputValue(val value: String) {

    init {
        require(value.isNotBlank()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_VALUE)
        }
        require(confirmRegularExpression()) {
            throw IllegalArgumentException(ErrorMessage.NOT_NUMBER_OR_FOUR_ARITHMETIC)
        }
    }

    private fun confirmRegularExpression(): Boolean {
        return valueSplit().all {
            it.matches(NUMBER_AND_FOUR_ARITHMETIC)
        }
    }

    private fun valueSplit() = value.split(SPACING)

    companion object {
        private val NUMBER_AND_FOUR_ARITHMETIC = "[-]?[0-9+\\-*/]".toRegex()
    }
}

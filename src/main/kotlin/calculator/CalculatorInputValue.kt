package calculator

import common.Constant.SPACING
import common.ErrorMessage

private val NUMBER_AND_FOUR_ARITHMETIC = "[-]?[0-9+\\-*/]".toRegex()
private const val NOT_NUMBER_OR_FOUR_ARITHMETIC = "숫자 또는 사칙연산 기호가 아닙니다."

class CalculatorInputValue(val value: String) {

    init {
        require(value.isNotBlank()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_VALUE)
        }
        require(confirmRegularExpression()) {
            throw IllegalArgumentException(NOT_NUMBER_OR_FOUR_ARITHMETIC)
        }
    }

    private fun confirmRegularExpression(): Boolean {
        return valueSplit().all {
            it.matches(NUMBER_AND_FOUR_ARITHMETIC)
        }
    }

    private fun valueSplit() = value.split(SPACING)
}

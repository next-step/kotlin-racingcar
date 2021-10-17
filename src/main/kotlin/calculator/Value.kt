package calculator

import common.ErrorMessage

class Value(val variable: String) {

    companion object {
        private val NUMBER_AND_FOUR_ARITHMETIC = "[0-9+\\-*/]".toRegex()
        private const val SPACING = " "
    }

    init {
        require(variable.isNotBlank()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_VALUE)
        }
        require(confirmRegularExpression()) {
            throw IllegalArgumentException(ErrorMessage.NOT_NUMBER_OR_FOUR_ARITHMETIC)
        }
    }

    private fun valueSplit() = variable.split(SPACING)
    private fun confirmRegularExpression(): Boolean {
        return valueSplit().stream().filter {
            !it.matches(NUMBER_AND_FOUR_ARITHMETIC)
        }.noneMatch {
            return@noneMatch true
        }
    }
}

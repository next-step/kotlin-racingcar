package calculator

import calculator.const.CalculatorException

object Parser {
    private val DELIMITER_SPLIT_REGEX = "\\s+".toRegex()

    fun parse(rawString: String?): Expression {
        require(!rawString.isNullOrBlank()) { CalculatorException.PARSING_ERROR }
        return Expression(rawString.split(DELIMITER_SPLIT_REGEX))
    }
}

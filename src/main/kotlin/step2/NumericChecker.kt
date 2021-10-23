package step2

import step2.ExceptionType.OPERAND_IS_MUST_NUMBER

object NumericChecker {
    private val numericRegex = "-?\\d+(\\.\\d+)?".toRegex()
    fun checkIsNumeric(s: String?) = requireNotNull(s?.matches(numericRegex)) { OPERAND_IS_MUST_NUMBER }
}

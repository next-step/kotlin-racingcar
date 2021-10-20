package step2

import step2.NumericChecker.checkIsNumeric

data class Operand(var value: Double) {
    constructor(s: String) :
        this(s.also { require(checkIsNumeric(it)) { ExceptionType.OPERAND_IS_MUST_NUMBER } }.toDouble())
}

package step2

import step2.ExceptionType.OPERAND_IS_MUST_NUMBER
import step2.NumericChecker.checkIsNumeric

class Operand(val value: Double) {
    constructor(s: String) :
        this(s.also { require(checkIsNumeric(it)) { OPERAND_IS_MUST_NUMBER } }.toDouble())
}

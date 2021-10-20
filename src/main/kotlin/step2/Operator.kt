package step2

import step2.ExceptionType.OPERATOR_IS_MUST_FIXED_SYMBOL
import step2.NumericChecker.checkIsNotNumeric

class Operator(private val symbol: String) {

    val calculateBlock = symbol.run {
        require(checkIsNotNumeric(symbol)) { OPERATOR_IS_MUST_FIXED_SYMBOL }
        OperatorType.getOperator(this)
    }

    fun execute(a: Operand, b: Operand) = calculateBlock(a, b)
}

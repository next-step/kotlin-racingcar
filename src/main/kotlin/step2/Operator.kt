package step2

import step2.ExceptionType.OPERATOR_IS_MUST_FIXED_SYMBOL
import step2.NumericChecker.checkIsNumeric

class Operator(private val symbol: String) {

    private val calculateBlock = symbol.run {
        require(!checkIsNumeric(symbol)) { OPERATOR_IS_MUST_FIXED_SYMBOL }
        OperatorType.findOperatorBySymbol(this)
    }

    fun execute(oldValue: Operand, newValue: Operand) = calculateBlock(oldValue, newValue)
}

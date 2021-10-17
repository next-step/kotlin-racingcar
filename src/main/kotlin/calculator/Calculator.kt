package calculator

import calculator.CalculatorException.FIRST_VALUE_INVALID_EXCEPTION
import calculator.CalculatorException.INTEGER_IS_NOT_LOCATED_EXCEPTION
import calculator.CalculatorException.INVALID_INPUT_EXCEPTION
import calculator.CalculatorException.IS_NOT_NULL_OR_BLANK_EXCEPTION

object Calculator {

    fun calculate(value: String?): Int {
        require(!value.isNullOrBlank()) { IS_NOT_NULL_OR_BLANK_EXCEPTION }

        val valueSplitList = value.trim().split(" ")
        var result = valueSplitList[0].toIntOrNull() ?: throw NumberFormatException(FIRST_VALUE_INVALID_EXCEPTION)
        require(valueSplitList.size % 2 != 0) { INVALID_INPUT_EXCEPTION }

        for (i in 1 until valueSplitList.size step 2) {
            result = calculate(result, valueSplitList[i], valueSplitList[i + 1].toIntOrNull() ?: throw NumberFormatException(INTEGER_IS_NOT_LOCATED_EXCEPTION))
        }
        return result
    }

    private fun calculate(num1: Int, op: String, num2: Int): Int {
        val operator = Operator.convertToOperator(op)
        return operator.calculate(num1, num2)
    }
}

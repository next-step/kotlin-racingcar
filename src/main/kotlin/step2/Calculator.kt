package step2

import step2.Step2Exception.CANT_PLACE_NUMBER_EXCEPTION
import step2.Step2Exception.FIRST_VALUE_INVALID_EXCEPTION
import step2.Step2Exception.IS_NOT_NULL_OR_BLANK_EXCEPTION
import step2.Step2Exception.STRING_NEXT_NOT_NUM_EXCEPTION

object Calculator {

    fun calculate(value: String?): Int {
        require(!value.isNullOrBlank()) { IS_NOT_NULL_OR_BLANK_EXCEPTION }
        val valueSplitList = value.trim().split(" ")

        var result = valueSplitList[0].toIntOrNull() ?: throw NumberFormatException(FIRST_VALUE_INVALID_EXCEPTION)
        for (i in 1 until valueSplitList.size - 1) {
            if (checkStringNextNum(valueSplitList[i], valueSplitList[i + 1])) {
                result = calculate(result, valueSplitList[i], valueSplitList[i + 1].toInt())
            }
        }
        return result
    }

    private fun checkStringNextNum(maybeOperator: String, maybeIntValue: String): Boolean {
        return if (maybeOperator.toIntOrNull() == null && maybeIntValue.toIntOrNull() != null) {
            true
        } else if (maybeOperator.toIntOrNull() == null && maybeIntValue.toIntOrNull() == null) {
            throw IllegalArgumentException(STRING_NEXT_NOT_NUM_EXCEPTION)
        } else if (maybeOperator.toIntOrNull() != null && maybeIntValue.toIntOrNull() != null) {
            throw IllegalArgumentException(CANT_PLACE_NUMBER_EXCEPTION)
        } else {
            return false
        }
    }

    private fun calculate(num1: Int, op: String, num2: Int): Int {
        val operator = Operator.convertToOperator(op)
        return operator.calculate(num1, num2)
    }
}

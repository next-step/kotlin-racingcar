package step2

import java.lang.IllegalArgumentException

class CalculatorChecker {
    private fun isNumber(str: String): Boolean {
        return str.toIntOrNull() != null
    }

    private fun isExpression(str: String): Boolean {
        return str == "+" || str == "-" || str == "*" || str == "/"
    }

    fun isEven(idx: Int) = idx % 2 == 0
    private fun isOdd(idx: Int) = idx % 2 == 1

    fun isFormulaValid(formulaQueue: List<String>): Boolean {
        formulaQueue.forEachIndexed { index, str ->
            if (isEven(index) && !isNumber(str)) return false
            if (isOdd(index) && (!isExpression(str) || index == formulaQueue.size - 1)) return false
        }

        return true
    }
}

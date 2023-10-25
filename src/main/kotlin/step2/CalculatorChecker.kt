package step2

class CalculatorChecker {
    private fun isNumber(str: String): Boolean {
        return str.toIntOrNull() != null
    }

    fun isEven(idx: Int) = idx % 2 == 0
    private fun isOdd(idx: Int) = idx % 2 == 1

    fun isFormulaValid(formulaQueue: List<String>): Boolean {
        formulaQueue.forEachIndexed { index, str ->
            if (isEven(index) && !isNumber(str)) return false
            if (isOdd(index) && (!isArithmeticExpression(str) || index == formulaQueue.size - 1)) return false
        }

        return true
    }

    private fun isArithmeticExpression(str: String): Boolean {
        return Arithmetic.values().find { str == it.expr } != null
    }
}

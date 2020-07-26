package step2

class Calculator {
    private val formulaSplitDelimiter = " "

    fun calculate(formula: String): Double {
        require(formula.isNotBlank()) { "값을 입력해 주세요" }

        val values = formula.split(formulaSplitDelimiter)
        var outcome = values[0].toDouble()
        var operator = getOperatorType(values[1])

        for (str in 2 until values.size) {
            val value = values[str]

            if (isNumber(value)) outcome = calculate(outcome, value.toDouble(), operator)
            if (isOperator(value)) operator = getOperatorType(value)
            if (!isValidFormula(value)) throw IllegalArgumentException("올바른 수식이 아닙니다.")
        }
        return outcome
    }

    private fun isValidFormula(str: String): Boolean {
        return isNumber(str) || isOperator(str)
    }

    private fun isNumber(str: String): Boolean {
        return try {
            str.toDouble()
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun isOperator(str: String): Boolean {
        val operatorType = getOperatorType(str)

        return operatorType == OperatorType.PLUS ||
            operatorType == OperatorType.MINUS ||
            operatorType == OperatorType.MULTIPLE ||
            operatorType == OperatorType.DIVIDE
    }

    private fun calculate(current: Double, change: Double, operator: OperatorType): Double {
        if (operator == OperatorType.PLUS) return current + change
        if (operator == OperatorType.MINUS) return current - change
        if (operator == OperatorType.MULTIPLE) return current * change
        if (operator == OperatorType.DIVIDE) return current / change
        return current / change
    }

    enum class OperatorType {
        PLUS,
        MINUS,
        MULTIPLE,
        DIVIDE
    }

    fun getOperatorType(s: String): OperatorType =
        when (s) {
            "+" -> OperatorType.PLUS
            "-" -> OperatorType.MINUS
            "*" -> OperatorType.MULTIPLE
            "/" -> OperatorType.DIVIDE
            else -> OperatorType.DIVIDE
        }
}

package step2

object CalculatorValidator {
    fun validateRegex(value: String) {
        val pattern = "^\\d+(\\s*[\\+\\-\\*\\/]\\s*\\d+)*$"
        require(Regex(pattern).matches(value)) {
            "올바른 계산식이 아닙니다."
        }
    }

    fun validateIsNumberOrOperator(value: String) {
        require(isNumber(value) || isOperator(value)) {
            "올바른 계산식이 아닙니다."
        }
    }

    fun isNumber(value: String): Boolean {
        try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }

    fun isOperator(value: String): Boolean {
        val operators = Operator.values().map { it.operator }
        return operators.contains(value)
    }
}

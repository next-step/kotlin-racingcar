package calculator

class CalculatorValidator {
    fun expressionValidate(expression: String) {
        if (expression.isBlank()) {
            throw IllegalArgumentException("Not Blank Expression")
        }
    }

    fun validateOperator(token: String) {
        if (!isOperator(token)) {
            throw IllegalArgumentException("Invalid operator: $token")
        }
    }

    private fun isOperator(token: String) = token in listOf("+", "-", "*", "/")
}

package calculator

data class ExpressionCalculator(var expression: String?, var splitedExpression: SplitedExpression) {
    constructor(inputExpression: String?) : this("", SplitedExpression("")) {
        validateExpression(inputExpression)
        expression = inputExpression
        deleteBlank()
        splitedExpression = SplitedExpression(expression)
    }

    private fun validateExpression(inputExpression: String?) {
        val nonPassRegex = "[^0-9+\\-*/ ]".toRegex()
        val operandRegex = "+-*/"
        if (inputExpression.isNullOrEmpty() || inputExpression.none { it in operandRegex } ||
            nonPassRegex.containsMatchIn(inputExpression)
        ) {
            throw IllegalArgumentException()
        }
    }

    private fun deleteBlank() {
        this.expression = expression?.replace(" ", "")
    }

    fun calculateResult(): Int {
        return splitedExpression.calculateResult()
    }
}

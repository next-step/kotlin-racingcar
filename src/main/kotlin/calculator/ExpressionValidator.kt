package calculator

import calculator.utils.rawExpressionSplit

object ExpressionValidator {
    fun validate(rawExpression: String) {
        val tokenizedExpressions = rawExpression.rawExpressionSplit()

        require(isRightSize(tokenizedExpressions)) { "올바른 수식을 입력해주세요." }
        require(isComputableExpression(tokenizedExpressions)) { "올바른 수식을 입력해주세요." }
    }

    private fun isRightSize(expression: List<String>): Boolean {
        if (expression.size < 3) return false
        if (expression.size % 2 == 0) return false

        return true
    }

    private fun isComputableExpression(expression: List<String>): Boolean {
        expression.forEachIndexed { index, tokenized ->
            val isValid = if (index % 2 == 0) isNumber(tokenized) else isOperator(tokenized)
            if (!isValid) throw IllegalArgumentException("올바른 수식을 입력해주세요.")
        }

        return true
    }

    private fun isNumber(expression: String): Boolean = expression.toDoubleOrNull() != null

    private fun isOperator(expression: String): Boolean = Operator.exist(expression)
}

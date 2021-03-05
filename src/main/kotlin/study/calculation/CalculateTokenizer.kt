package study.calculation

class CalculateTokenizer {
    companion object {
        private const val TOKEN_SEPERATOR = " "
    }

    fun tokenize(stringExpression: String): ExpressionToken {
        blankValidate(stringExpression)
        val stringTokens = stringExpression.split(TOKEN_SEPERATOR)
        invalidExpressionValidate(stringTokens)
        val operators: List<String> = stringTokens.filter { Operator.isOperator(it) }
        val operands: List<Int> = stringTokens.filterNot { Operator.isOperator(it) }.map { it.toInt() }
        invalidExpressionValidate(operators, operands)
        return ExpressionToken(operators, operands)
    }

    private fun blankValidate(expression: String) {
        require(!expression.isBlank()) {
            "입력 값이 빈 공백 문자열 입니다."
        }
    }
    private fun invalidExpressionValidate(stringTokens: List<String>) {
        require(stringTokens.size >= 3 && stringTokens.size % 2 != 0 && !Operator.isOperator(stringTokens[0])) {
            "올바른 식이 아닙니다."
        }
    }

    private fun invalidExpressionValidate(operators: List<String>, operands: List<Int>) {
        require(operands.size - operators.size == 1) {
            "올바른 식이 아닙니다."
        }
    }
}

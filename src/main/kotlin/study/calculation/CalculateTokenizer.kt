package study.calculation

class CalculateTokenizer {
    companion object {
        private const val TOKEN_SEPERATOR = " "
    }

    fun tokenize(stringExpression: String): ExpressionToken {
        validate(stringExpression)
        val stringTokens = stringExpression.split(TOKEN_SEPERATOR)
        val token = ExpressionToken()
        token.addOperand(stringTokens[0].toInt())

        for (i in 2..stringTokens.size step 2) {
            token.addOperator(stringTokens[i - 1])
            token.addOperand(stringTokens[i].toInt())
        }
        return token
    }

    private fun validate(expression: String) {
        require(!expression.isBlank()) {
            "입력 값이 빈 공백 문자열 입니다."
        }
        require(expression.split(TOKEN_SEPERATOR).size >= 3 && expression.split(TOKEN_SEPERATOR).size % 2 != 0) {
            "올바른 식이 아닙니다."
        }
    }
}

package study.calculation

class CalculateTokenizer {

    fun tokenize(stringExpression: String?): ExpressionToken {
        validate(stringExpression)
        val stringTokens = stringExpression!!.split(" ")
        val token = ExpressionToken()
        token.addOperand(stringTokens[0].toInt())

        for (i in 2..stringTokens.size step 2) {
            token.addOperator(stringTokens[i - 1])
            token.addOperand(stringTokens[i].toInt())
        }
        return token
    }

    private fun validate(expression: String?) {
        require(!expression.isNullOrBlank()) {
            "입력 값이 null 이거나 빈 공백 문자열 입니다."
        }
        require(expression.split(" ").size >= 3 && expression.split(" ").size % 2 != 0) {
            "올바른 식이 아닙니다."
        }
    }
}

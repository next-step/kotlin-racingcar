package study.step2

import java.lang.IllegalArgumentException

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
        if (expression.isNullOrBlank()) throw IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자열 입니다.")
        if (expression.split(" ").size < 3 || expression.split(" ").size % 2 == 0) throw IllegalArgumentException("올바른 식이 아닙니다.")
    }
}

package calculator

class StringCalculator {
    fun calculate(expression: StringExpression): Int {
        val tokens = expression.tokenize()

        val firstNumber = StringExpressionOperand(tokens.first())

        return tokens
            .drop(1)
            .chunked(2)
            .fold(firstNumber) { acc, cur ->
                StringExpressionOperator(cur[0]).apply(
                    acc,
                    StringExpressionOperand(cur[1])
                )
            }
            .number
    }
}

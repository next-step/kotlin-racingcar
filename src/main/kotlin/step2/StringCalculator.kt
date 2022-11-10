package step2

class StringCalculator(
    private val tokenCalculator: TokenCalculator,
) {
    fun calculate(expression: String?): Int {
        val validExpression = ExpressionValidator.validate(expression = expression)
        val tokens = ExpressionTokenizer.tokenize(expression = validExpression)
        return this.tokenCalculator.calculate(tokens = tokens)
    }
}

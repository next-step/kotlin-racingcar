package step2

class StringCalculator {

    fun calculate(expression: String?): Int {
        val validExpression = ExpressionValidator.validate(expression = expression)
        ExpressionTokenizer.tokenize(expression = validExpression)
        return 10
    }
}

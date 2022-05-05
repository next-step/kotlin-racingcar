package calculator

class StringCalculator(
    private val expressionFactory: ExpressionFactory
) {
    fun calculate(expressionText: String): Int {
        val expression = expressionFactory.create(expressionText)
        return expression.calculate()
    }
}

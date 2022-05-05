package calculator

class StringCalculator(
    private val expressionFactory: ExpressionFactory
) {
    fun calculate(expressionText: String): Int {
        val expression = expression(expressionText)
        return expression.calculate()
    }
    private fun expression(expressionText: String) = expressionFactory.create(expressionText)
}

package calculator

class StringCalculator(
    private val expressionSeparator: String = " "
) {
    fun calculate(expressionText: String): Int {
        val expression = Expression.of(expressionText, expressionSeparator)
        return expression.calculate()
    }
}

package calculator

object StringCalculator {
    private val blankRegex = Regex(" +")
    private val allowedNumberCharacters = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

    fun calculate(arithmeticExpression: String): Float {
        val splitedExpression = arithmeticExpression.split(blankRegex)
        val numbers = splitedExpression.filter { it in allowedNumberCharacters }.map { it.toFloat() }
        val symbols = splitedExpression.filter { Operator.isOperatorSymbol(it) }.map { Operator.findBySymbol(it) }
        val expression = Expression(numbers, symbols)

        return expression.sum()
    }
}

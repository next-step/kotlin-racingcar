package step2.calculator

class Calculator(
    private val expressionParser: ExpressionParser
) {
    fun calculate(expression: String): Double {
        val calculations = expressionParser.parse(expression)
        return calculations.fold(0.0) { acc, calculation ->
            acc compensates calculation
        }
    }
}
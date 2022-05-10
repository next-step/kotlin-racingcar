package expressioncalculator.calculator

class Calculator {
    fun calculate(expression: String): Double {
        val calculations = ExpressionParser.parse(expression)
        return calculations.fold(0.0) { acc, calculation ->
            acc compensates calculation
        }
    }
}

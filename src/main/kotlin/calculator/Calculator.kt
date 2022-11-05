package calculator

class Calculator {
    private fun Double.calculate(expression: Pair<Operator, Double>): Double =
        expression.let { (operator, operand) ->
            operator(this, operand)
        }

    fun calculate(rawExpress: String): Double =
        Parser().parse(rawExpress).fold(0.0) { acc, expression ->
            acc.calculate(expression)
        }
}

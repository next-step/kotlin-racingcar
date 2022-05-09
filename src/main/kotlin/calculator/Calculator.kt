package calculator

object Calculator {

    @Throws(IllegalArgumentException::class)
    fun calculate(string: String): Float {
        val expression = parseExpression(string)

        val first = expression.first().toFloat()

        return expression
            .drop(1)
            .chunked(2) { (operatorString, numberString) ->
                val operator = requireNotNull(MathOperator.from(operatorString))
                val number = numberString.toFloat()
                operator to number
            }.fold(first) { acc, (operator, number) ->
                operator.calculate(acc, number)
            }
    }

    private fun parseExpression(string: String): List<String> {
        return string
            .replace(oldValue = " ", newValue = "")
            .replace(Regex("([+\\-*/])")) { " ${it.value} " }
            .split(" ")
    }
}

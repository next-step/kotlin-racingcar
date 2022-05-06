package calculator

object Calculator {

    @Throws(IllegalArgumentException::class)
    fun calculate(string: String): Float {
        val expression = parseExpression(string)

        var result = expression.first().toFloat()

        expression
            .drop(1)
            .windowed(2, 2) { (operatorString, numberString) ->
                val operator = MathOperator.from(operatorString) ?: throw IllegalArgumentException()
                val number = numberString.toFloat()
                result = operator.calculate(result, number)
            }

        return result
    }

    private fun parseExpression(string: String): List<String> {
        return string
            .replace(" ", "")
            .replace(Regex("([+\\-*/])")) { " ${it.value} " }
            .split(" ")
    }
}

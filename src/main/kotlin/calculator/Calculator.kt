package calculator

class Calculator {

    fun calculator(expression: String): Long {
        validCheck(expression)
        val expressions = expression.splitByBlank()
        var result = expressions[0].toLong()
        for (index in 1 until expressions.size step 2) {
            result = calculate(
                operator = Operator.find(expressions[index]),
                number1 = result,
                number2 = expressions[index + 1].toLong()
            )
        }
        return result
    }

    private fun String.splitByBlank() = this.split(" ")

    private fun validCheck(expression: String?) {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("Empty Expression")
        if (isOperatorValid(expression)) throw IllegalArgumentException("Invalid Operator")
    }

    private fun calculate(operator: Operator, number1: Long, number2: Long) = when (operator) {
        Operator.PLUS -> number1.plus(number2)
        Operator.MINUS -> number1.minus(number2)
        Operator.DIVISION -> number1.div(number2)
        Operator.MULTIPLE -> number1.times(number2)
    }
}

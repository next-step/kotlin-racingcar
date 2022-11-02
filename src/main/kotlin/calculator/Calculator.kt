package calculator

enum class Operator(val value: String) {
    PLUS("+"), MINUS("-"), DIVISION("/"), MULTIPLE("*");
}

class Calculator {

    fun calculator(expression: String) {
        validCheck(expression)
        val expressions = expression.splitByBlank()
        var result = expressions[0].toLong()
        for (index in 1 until expressions.size step 2) {
            result = result.calculate(
                operator = Operator.valueOf(expressions[index]),
                number = expressions[index + 1].toLong()
            )
        }
    }

    private fun String.splitByBlank() = this.split(" ")

    private fun validCheck(expression: String?) {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("Empty Expression")
        if (isOperatorValid(expression)) throw IllegalArgumentException("Invalid Operator")
    }

    private fun isOperatorValid(expression: String) =
        extractOperator(expression).isNotEmpty()

    private fun extractOperator(expression: String) =
        extractNumber(expression).replace(Regex(makeOperatorRegex()), "")

    private fun extractNumber(expression: String) =
        expression.replace(Regex("[0-9]"), "")

    private fun makeOperatorRegex() =
        "[${Operator.values().joinToString("|")}]"

    private fun Long.calculate(operator: Operator, number: Long) =
        when (operator) {
            Operator.PLUS -> this.plus(number)
            Operator.MINUS -> this.minus(number)
            Operator.DIVISION -> this.div(number)
            Operator.MULTIPLE -> this.times(number)
        }
}

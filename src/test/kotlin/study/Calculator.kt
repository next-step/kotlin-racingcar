package study

class Calculator {

    fun calculate(expression: String): Int {
        if (expression.isEmpty()) throw IllegalArgumentException("Input value is null or empty")
        val tokenList = expression.split(" ").toList()
        var result = tokenList[0].toInt()

        for (i in 1 until tokenList.size - 1 step 2) {
            if (tokenList[i].isEmpty() || tokenList[i + 1].isEmpty()) throw IllegalArgumentException("Input value is null or empty")
            result = Calculator().executeOperation(
                number1 = result, operator = tokenList[i], number2 = tokenList[i + 1].toInt()
            )
        }
        return result
    }

    private fun executeOperation(number1: Int, operator: String, number2: Int): Int = when (operator) {
        "+" -> number1.plus(number2)
        "-" -> number1.minus(number2)
        "*" -> number1.times(number2)
        "/" -> number1.div(number2)
        else -> throw IllegalArgumentException("Not an arithmetic operator")
    }
}

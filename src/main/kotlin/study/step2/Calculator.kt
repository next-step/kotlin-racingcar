package study.step2

class Calculator {

    fun add(number: Int, number2: Int): Int = number + number2

    fun subtract(number: Int, number2: Int): Int = number - number2

    fun multiply(number: Int, number2: Int): Int = number * number2

    fun divide(number: Int, number2: Int): Int = number / number2

    fun calculateExpression(expression: List<String>): Int {
        var acc = getNumber(expression[0])

        for (i in 1 until expression.size step 2) {
            val operator = expression[i]
            val to = getNumber(expression[i + 1])

            acc = calculate(acc, operator, to)
        }

        return acc
    }

    private fun calculate(from: Int, operator: String, to: Int): Int {
        return when (operator) {
            FourRuleCalculations.ADD.symbol -> add(from, to)
            FourRuleCalculations.SUBTRACT.symbol -> subtract(from, to)
            FourRuleCalculations.MULTIPLY.symbol -> multiply(from, to)
            FourRuleCalculations.DIVISION.symbol -> divide(from, to)
            else -> throw IllegalArgumentException("Invalid Symbol")
        }
    }

    private fun getNumber(token: String): Int {
        return token.toIntOrNull() ?: throw IllegalArgumentException()
    }
}

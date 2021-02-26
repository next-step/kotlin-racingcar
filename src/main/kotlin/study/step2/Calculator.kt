package study.step2

class Calculator {

    fun add(number: Int, number2: Int): Int = number + number2

    fun subtraction(number: Int, number2: Int): Int = number - number2

    fun multiply(number: Int, number2: Int): Int = number * number2

    fun division(number: Int, number2: Int): Int = number / number2

    fun calculateExpression(expression: List<String>): Int {
        var acc: Int
        var to: Int
        var operator: String

        acc = getNumber(expression[0])

        for (i in 1 until expression.size step 2) {
            operator = expression[i]
            to = getNumber(expression[i + 1])

            acc = calculate(acc, operator, to)
        }

        return acc
    }

    fun calculate(from: Int, operator: String, to: Int): Int {
        return when (operator) {
            CalculationsSymbol.ADD.symbol -> add(from, to)
            CalculationsSymbol.SUB.symbol -> subtraction(from, to)
            CalculationsSymbol.MULTIPLY.symbol -> multiply(from, to)
            CalculationsSymbol.DIVISION.symbol -> division(from, to)
            else -> throw IllegalArgumentException()
        }
    }

    fun getNumber(token: String): Int {
        return token.toIntOrNull() ?: throw IllegalArgumentException()
    }
}

package calculator

class Calculator {
    fun calculate(expression: String?): Int {
        val symbols = checkNullOrBlank(expression).split(DELIMITER)
        var result = symbols[0].toInt()

        for (i in 1 until symbols.size step EXPRESSION_LENGTH) {
            val operator = Operator.findOperator(symbols[i])
            val number = symbols[i + 1].toInt()
            result = operator.operate(result, number)
        }

        return result
    }

    companion object {
        const val DELIMITER = " "
        const val EXPRESSION_LENGTH = 2
    }
}

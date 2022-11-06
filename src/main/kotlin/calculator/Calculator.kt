package calculator

object Calculator {

    private const val BLANK = " "
    private const val INDEX_OF_FIRST_OPERATOR = 1
    private const val PAIR = 2

    fun calculate(input: String?): Int {
        val expression = processInput(input)
        var result = expression.first().toInt()

        for (i in INDEX_OF_FIRST_OPERATOR until expression.size step PAIR) {
            val (operator, operand) = getOperatorAndOperand(index = i, expression = expression)
            result = operator.operate(result, operand)
        }

        return result
    }

    private fun processInput(input: String?): List<String> {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("The input value is null or empty.") }
        return input.split(BLANK)
    }

    private fun getOperatorAndOperand(index: Int, expression: List<String>): Pair<Operator, Int> {
        val indexOfOperand = index + 1
        val operator = Operator.symbolOf(expression[index])
        val operand = if (indexOfOperand == expression.size) {
            throw IllegalArgumentException("The input value is invalid")
        } else {
            expression[indexOfOperand].toInt()
        }

        return Pair(operator, operand)
    }
}

package calculator

object Calculator {

    private const val BLANK = " "
    private const val INDEX_OF_FIRST_OPERATOR = 1
    private const val PAIR = 2

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("The input value is null or empty.") }

        val expression = input.split(BLANK)
        var result = expression.first().toInt()

        for (i in INDEX_OF_FIRST_OPERATOR until expression.size step PAIR) {
            val operator = Operator.symbolOf(expression[i])
            val operand = expression[i + 1].toInt()
            result = operator.operate(result, operand)
        }

        return result
    }
}

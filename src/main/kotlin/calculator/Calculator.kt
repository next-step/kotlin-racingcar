package calculator

object Calculator {

    private const val BLANK = " "

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("The input value is null or empty.") }

        val expression = input.split(BLANK)
        var result = expression.first().toInt()

        for (i in 1 until expression.size step 2) {
            val operator = Operator.symbolOf(expression[i])
            val operand = expression[i + 1].toInt()
            result = operate(result, operator, operand)
        }

        return result
    }
}

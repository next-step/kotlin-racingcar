package step2

class Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("expression is null or blank")
        val tokens = expression.split(" ")
        if (tokens.size % 2 == 0) throw IllegalArgumentException("expression is not completed")
        var result = Operand.of(tokens[0]).value
        for (i in 1 until tokens.size step 2) {
            val operand = Operator.of(tokens[i])
            val right = Operand.of(tokens[i + 1])
            result = operand.calculate(result, right.value)
        }
        return result
    }
}

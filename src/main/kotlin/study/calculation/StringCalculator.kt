package study.calculation

class StringCalculator(private val calculateTokenizer: CalculateTokenizer) {
    fun calculate(stringExpression: String): Int {
        val token = calculateTokenizer.tokenize(stringExpression)
        var left = token.operands[0]

        token.operators.forEachIndexed { i, oper ->
            val right = token.operands[i + 1]
            val calculation = Operator.select(oper).calculation
            left = calculation(left, right)
        }

        return left
    }
}

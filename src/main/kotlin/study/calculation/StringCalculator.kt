package study.step2

class StringCalculator(private val calculateTokenizer: CalculateTokenizer) {
    fun calculate(stringExpression: String): Int {
        val token = calculateTokenizer.tokenize(stringExpression)
        var left = token.operands[0]

        token.operators.forEachIndexed { i, operator ->
            val right = token.operands[i + 1]
            val calculation = CalculationFactory.create(operator)
            left = calculation.calculate(left, right)
        }

        return left
    }
}

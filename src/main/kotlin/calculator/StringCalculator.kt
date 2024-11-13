package calculator

class StringCalculator : Calculator {
    override fun calculate(expression: Expression): Double {
        val numbers = expression.extractNumbers()
        val operators = expression.extractOperators()

        return operators.foldIndexed(numbers.first()) { index, acc, operator ->
            val nextOperand = numbers[index + 1]
            operator.apply(acc, nextOperand)
        }
    }
}

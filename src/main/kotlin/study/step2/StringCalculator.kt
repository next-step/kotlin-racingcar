package study.step2

class StringCalculator(
    private val expressionFactory: ExpressionFactory
) {
    fun calculate(input: String?): Long {
        val expression = expressionFactory.create(input)
        return expression.calculate()
    }
}

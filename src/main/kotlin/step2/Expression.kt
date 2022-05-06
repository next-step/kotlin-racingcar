package step2

class Expression(
    private val number: Int, private val calculator: Calculator, private val nextExpression: Expression?
) {
    fun execute(preNumber: Int): Int {
        val result = calculator.calculate(preNumber, number)
        if (nextExpression == null) {
            return result
        }
        return nextExpression.execute(result)
    }
}

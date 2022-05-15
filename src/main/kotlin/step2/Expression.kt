package step2

class Expression(
    private val arithmeticOperation: ArithmeticOperation,
    private val number: Int,
    private val nextExpression: Expression? = null
) {
    fun execute(preNumber: Int): Int {
        val result = arithmeticOperation.execute(preNumber, number)
        if (nextExpression == null) {
            return result
        }
        return nextExpression.execute(result)
    }
}

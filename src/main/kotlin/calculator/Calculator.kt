package calculator

class Calculator(private val expression: String) {
    fun calculate(): Int {
        require(!expression.isNullOrBlank())

        val separateExpression = expression.split(EXPRESSION_SEPARATOR).iterator()

        var calculated = separateExpression.next().toInt()

        while (separateExpression.hasNext()) {
            calculated = calculateNextStep(calculated, separateExpression)
        }

        return calculated
    }
    private fun calculateNextStep(calculated: Int, separateExpression: Iterator<String>): Int {
        val operation = Operation.operationOf(separateExpression.next())
        val number = separateExpression.next().toInt()

        return operation.calc(calculated, number)
    }

    companion object {
        val EXPRESSION_SEPARATOR = " "
    }
}

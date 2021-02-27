package calculator

class Calculator(private val expression: String?) {
    fun calculate(): Int {
        require(!expression.isNullOrBlank())

        val separateExpression = expression.split(" ").iterator()

        var calculated = Integer.parseInt(separateExpression.next())

        while (separateExpression.hasNext()) {
            calculated = calculateNextStep(calculated, separateExpression)
        }

        return calculated
    }
    private fun calculateNextStep(calculated: Int, separateExpression: Iterator<String>): Int {
        val operation = Operation.operationOf(separateExpression.next())
        val number = Integer.parseInt(separateExpression.next())

        return operation.calc(calculated, number)
    }
}

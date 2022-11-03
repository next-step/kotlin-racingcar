package step1.calculator

class StringCalculator(expression: String) {
    private val separateExpression = expression.split(DELIMITER)
    private var result = separateExpression[0].toDouble()

    fun calculate(): Double {
        separateExpression.forEachIndexed { index, it ->
            operateEachExpression(index)
        }
        return result
    }

    private fun operateEachExpression(index: Int) {
        if (isOddIndex(index)) {
            val rightValue = separateExpression[index + 1].toDouble()
            val operation = OperationType.match(separateExpression[index])
            result = operation.calculate(result, rightValue)
        }
    }

    fun isOddIndex(index: Int): Boolean = index % 2 != 0

    companion object {
        private const val DELIMITER = " "
    }
}

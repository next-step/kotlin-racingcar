package calculator

class StringCalculator {
    companion object {
        private const val DELIMITER = " "
    }

    fun calculate(stringExpression: String?): Scalar {
        if (stringExpression == null || stringExpression.isBlank()) {
            throw IllegalArgumentException("The expression is null or blank. expression='$stringExpression'")
        }

        return calculate(stringExpression).result
    }

    private fun calculate(stringExpression: String): Operation {
        return stringExpression.trim()
            .split(DELIMITER)
            .foldIndexed(Operation.Empty, ::operateExpression)
    }

    private fun operateExpression(index: Int, operation: Operation, value: String): Operation {
        if (isOdd(index)) {
            return operation.with(parseOperator(index, value))
        }

        return operation.with(parseOperand(index, value))
    }

    private fun isOdd(integer: Int) = integer % 2 == 1

    private fun parseOperand(index: Int, value: String): Operand {
        try {
            return Scalar.parse(value)
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException("${error.message} index='$index', value='$value''", error)
        }
    }

    private fun parseOperator(index: Int, value: String): Operator {
        try {
            return Operator.parse(value)
        } catch (error: IllegalArgumentException) {
            throw IllegalArgumentException("${error.message} index='$index', value='$value''", error)
        }
    }
}

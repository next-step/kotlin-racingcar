package calculator

class StringCalculator {
    companion object {
        private const val DELIMITER = " "
    }

    fun calculate(stringExpression: String?): Scalar {
        if (stringExpression.isNullOrBlank()) {
            throw IllegalArgumentException("The expression is null or blank. expression='$stringExpression'")
        }

        return try {
            calculate(stringExpression).result
        } catch (e: IllegalStateException) {
            throw IllegalArgumentException("The expression is end with operator. expression='$stringExpression'")
        }
    }

    private fun calculate(stringExpression: String): Operation {
        return stringExpression.trim()
            .split(DELIMITER)
            .foldIndexed(Operation.EMPTY, ::operateExpression)
    }

    private fun operateExpression(index: Int, operation: Operation, value: String): Operation {
        if (isOdd(index)) {
            operation.operator = parseOperator(index, value)
            return operation
        }

        return operation.operate(parseOperand(index, value))
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

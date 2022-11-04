package step1.calculator

class StringCalculator(expression: String) {
    init {
        validateExpression(expression)
    }

    private fun validateExpression(expression: String) {
        if (isLessThanMinimumExpressionLength(expression.trim().length)) {
            throw IllegalArgumentException(LESS_THAN_MINIMUM_EXPRESSION_LENGTH_ERROR_MESSAGE)
        }
    }

    private fun isLessThanMinimumExpressionLength(length: Int) = length < MINIMUM_EXPRESSION_LENGTH

    private val separateExpression = expression.split(DELIMITER)
    private var result = coverToTerm(0)

    fun calculate(): Number {
        separateExpression.forEachIndexed { index, it ->
            operateEachExpression(index, it)
        }
        return calibrate(result)
    }

    private fun calibrate(result: Double): Number {
        if (result % 1 == 0.0) {
            return result.toInt()
        }
        return result
    }

    private fun operateEachExpression(index: Int, currentValue: String) {
        if (isOddIndex(index)) {
            val operation = OperationType.match(currentValue)
            val rightTerm = coverToTerm(index + 1)
            result = operation.calculate(result, rightTerm)
        }
    }

    private fun isOddIndex(index: Int): Boolean = index % 2 != 0

    private fun coverToTerm(index: Int): Double {
        validateTerm(separateExpression[index])
        return separateExpression[index].toDouble()
    }

    private fun validateTerm(currentValue: String) {
        if (isNotNumber(currentValue)) {
            throw IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE)
        }
    }

    private fun isNumber(currentValue: String) = currentValue.toDoubleOrNull() != null
    private fun isNotNumber(currentValue: String) = !isNumber(currentValue)

    companion object {
        private const val LESS_THAN_MINIMUM_EXPRESSION_LENGTH_ERROR_MESSAGE = "최소 두개의 항과 1개의 연산자를 입력하세요"
        private const val INVALID_NUMBER_ERROR_MESSAGE = "연산 대상 항목에는 숫자만 입력하세요"
        private const val DELIMITER = " "
        private const val MINIMUM_EXPRESSION_LENGTH = 3
    }
}

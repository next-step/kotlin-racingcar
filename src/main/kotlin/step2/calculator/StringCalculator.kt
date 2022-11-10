package step2.calculator

class StringCalculator {
    fun calculate(expression: String): Number {
        val separateExpression: List<String> = ExpressionParser.parse(expression)
        return calculateExpression(separateExpression)
    }

    private fun calculateExpression(separateExpression: List<String>): Number {
        var result: Double = toOperand(separateExpression[0])

        for (i in 1 until separateExpression.size step 2) {
            val operator: OperationType = OperationType.match(separateExpression[i])
            val rightOperand: Double = toOperand(separateExpression[i + 1])
            result = operator.calculate(result, rightOperand)
        }
        return calibrate(result)
    }

    private fun toOperand(currentValue: String): Double = validateOperand(currentValue)

    private fun calibrate(result: Double): Number {
        if (result.hasNoRemainder()) {
            return result.toInt()
        }
        return result
    }

    private fun validateOperand(currentValue: String) =
        requireNotNull(currentValue.toDoubleOrNull()) { INVALID_NUMBER_ERROR_MESSAGE }

    companion object {
        private const val INVALID_NUMBER_ERROR_MESSAGE = "연산 대상 항목에는 숫자만 입력하세요"
    }
}

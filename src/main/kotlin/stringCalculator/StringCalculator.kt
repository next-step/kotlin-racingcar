package stringCalculator

class StringCalculator {
    companion object {
        const val STEP_SIZE = 2
    }

    fun calculate(expression: String?): Int {
        val expressionValues = convertExpressionToList(expression)
        var result = validateIsNumberAndConvert(expressionValues[0])
        for (i in 1 until expressionValues.size - 1 step STEP_SIZE) {
            val operator = Operator.findByOperator(expressionValues[i])
            val rightValue = validateIsNumberAndConvert(expressionValues[i + 1])
            result = operator.apply(result, rightValue)
        }
        return result
    }

    private fun convertExpressionToList(expression: String?): List<String> {
        if (expression.isNullOrEmpty()) throw IllegalArgumentException("null 또는 공백은 전달할 수 없습니다.")
        return expression.split(" ")
    }

    private fun validateIsNumberAndConvert(str: String): Int {
        return str.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.")
    }
}

package stringCalculator

object StringCalculator {
    private const val SPACE_SYMBOL = " "

    fun calculate(expression: String?): Int {
        val expressionValues = convertExpressionToList(expression)
        return expressionValues
            .drop(1)
            .chunked(2)
            .fold(validateIsNumberAndConvert(expressionValues[0])) { acc, (op, right) ->
                val operator = Operator.findByOperator(op)
                val rightValue = validateIsNumberAndConvert(right)
                operator.apply(acc, rightValue)
            }
    }

    private fun convertExpressionToList(expression: String?): List<String> {
        if (expression.isNullOrEmpty()) throw IllegalArgumentException("null 또는 공백은 전달할 수 없습니다.")
        return expression.split(SPACE_SYMBOL)
    }

    private fun validateIsNumberAndConvert(str: String): Int {
        return str.toIntOrNull() ?: throw IllegalArgumentException("${str}은 숫자가 아닙니다.")
    }
}

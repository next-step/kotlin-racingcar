package study.step2

class Calculator(val expressionParser: ExpressionParser) {

    fun calculate(expression: String?): Double {
        requireValidExpression(expression)
        val (numbers, operators) = expressionParser.parse(expression!!)

        var result = numbers[0]
        operators.forEachIndexed { index, operator ->
            result = operator.operate(result, numbers[index + 1])
        }

        return result
    }

    private fun requireValidExpression(expression: String?) {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("잘못된 계산식 입니다")
    }
}

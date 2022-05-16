package study.step2

class Calculator(private val expressionParser: ExpressionParser) {

    fun calculate(expression: String): Double {
        requireValidExpression(expression)
        val (numbers, symbols) = expressionParser.parse(expression)

        var result = numbers[0]
        symbols.forEachIndexed { index, symbol ->
            result = symbol.operate(result, numbers[index + 1])
        }

        return result
    }

    private fun requireValidExpression(expression: String) {
        require(expression.isNotBlank()) { "잘못된 계산식 입니다" }
    }
}

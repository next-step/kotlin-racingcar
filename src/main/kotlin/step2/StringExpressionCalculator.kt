package step2

object StringExpressionCalculator {
    fun calculate(input: String): Int {
        val expressionStr = input.replace(Regex("\\s+"), "")
        val firstNum: Int = input[0].digitToInt()
        val expression: Expression = StringExpressionParser.parse(expressionStr) ?: return firstNum
        return expression.execute(firstNum)
    }
}

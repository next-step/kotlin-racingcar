package step2

object StringExpressionParser {
    private val FORMULA_REGEX = Regex("\\d([+|\\-|*|/]\\d)*")
    fun parse(input: String): Expression? {
        if (input.isEmpty() || FORMULA_REGEX.matchEntire(input) == null) {
            throw IllegalArgumentException("입력된 문자열이 올바르지 않습니다. $input")
        }
        return parseFormula(input)
    }

    private fun parseFormula(formulaStr: String): Expression? {
        var expression: Expression? = null
        for (i: Int in formulaStr.length - 1 downTo 1) {
            if (i % 2 == 1) {
                continue
            }

            val number = formulaStr[i].digitToInt()
            val arithmeticOperation = ArithmeticOperation.findOperation(formulaStr[i - 1])
            expression = Expression(
                arithmeticOperation = arithmeticOperation,
                number = number,
                nextExpression = expression
            )
        }
        return expression
    }
}

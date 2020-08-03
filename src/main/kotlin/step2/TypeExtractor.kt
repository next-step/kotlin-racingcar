package step2

object TypeExtractor {

    private val numberRegex by lazy { Regex("""\d+""") }
    private val operatorRegex by lazy { Regex("""[\-+/*]""") }

    fun extractNumber(input: String) =
        numberRegex.findAll(input).map { it.groupValues[0].toInt() }.toList()

    fun extractOperator(input: String) =
        operatorRegex.findAll(input).map { it.groupValues[0] }.toList()

    fun extract(replaceInput: String): Pair<List<Int>, List<Operator>> {
        val number = extractNumber(replaceInput)
        val expression = extractOperator(replaceInput).mappingOperator()
        if (ExpressionChecker.isEmpty(number, expression))
            throw IllegalArgumentException("Invalid empty expression")
        if (!ExpressionChecker.isValidExpressionSize(number, expression))
            throw IllegalArgumentException("Invalid expression's format")
        return number to expression
    }

    fun List<String>.mappingOperator(): List<Operator> {
        return map { operator ->
            Operator.values().find { it.symbol == operator } ?: error("Invalid operator type")
        }
    }
}

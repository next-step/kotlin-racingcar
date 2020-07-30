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
        return map {
            // it 이 객체면 composition 으로 처리해서 when 제거할 수 있을 것 같은데.. & 대수타입이면 else 문도 제거 가능
            when (it) {
                Operator.ADD.symbol -> Operator.ADD
                Operator.SUB.symbol -> Operator.SUB
                Operator.MUL.symbol -> Operator.MUL
                Operator.DIV.symbol -> Operator.DIV
                else -> error("Invalid operator type")
            }
        }
    }
}

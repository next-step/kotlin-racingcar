inline fun Sequence<MatchResult>.reduce(operation: (acc: Int, operator: String, value: Int) -> Int): Int {
    var accumulator = 0

    for (element in this) {
        accumulator = if (element.groupValues[1].isNotEmpty())
            element.groupValues[1].toInt()
        else accumulator

        accumulator = operation(accumulator, element.groupValues[2], element.groupValues[3].toInt())
    }
    return accumulator
}


object Calculator {
    private val EXPRESSION_REGEX = """(\d*) ([+\-*/]) (\d*)""".toRegex()
    private const val NOT_EMPTY_OR_NULL_MSG = "입력 값은 null 또는 빈 문자열을 사용할 수 없습니다."
    private const val NOT_MATCH_EXPRESSION = "X operator Y 규칙에 맞지 않는 포멧입니다."
    private const val NOT_DEFINED_OPERATOR = "미정의된 연산입니다."

    fun run(expression: String?): Int {

        requireNotNull(expression) { NOT_EMPTY_OR_NULL_MSG }

        val matches = EXPRESSION_REGEX.findAll(expression)

        require(!matches.none()) { NOT_MATCH_EXPRESSION }

        return matches.reduce { total, operation, newValue ->
            calculate(total, operation, newValue)
        }
    }

    private fun calculate(firstValue: Int, operator: String, secondValue: Int): Int {
        return when (operator) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "*" -> firstValue * secondValue
            "/" -> firstValue / secondValue
            else -> throw IllegalArgumentException(NOT_DEFINED_OPERATOR)
        }
    }
}

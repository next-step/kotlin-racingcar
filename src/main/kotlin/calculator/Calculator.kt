package calculator

object Calculator {
    private val EXPRESSION_REGEX = """(\d*) ([+\-*/]) (\d*)""".toRegex()
    private const val NOT_EMPTY_OR_NULL_MSG = "입력 값은 null 또는 빈 문자열을 사용할 수 없습니다."
    private const val NOT_MATCH_EXPRESSION = "X operator Y 규칙에 맞지 않는 포멧입니다."

    fun calculate(expression: String?): Int {

        requireNotNull(expression) { NOT_EMPTY_OR_NULL_MSG }

        val matches = EXPRESSION_REGEX.findAll(expression)

        require(!matches.none()) { NOT_MATCH_EXPRESSION }

        return matches.reduce { total, operation, newValue ->
            Operator.of(operation).expression(total, newValue)
        }
    }
}

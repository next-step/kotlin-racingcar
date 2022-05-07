/**
 *  Kotlin reduce 로직을 베이스로 작성되었습니다.
 *
 * accumulator 초기값은 0 입니다.
 * [1] MatchResult 첫번째 연산은 x + y : x 값이 "" 빈 문자열이 아니기 때문에 accumulator 을 x + y 의 결과 값으로 설정됩니다.
 * [2] 두번째 연산 부터 "" + y : 선행된 연산 값이 있기 때문에 1번의 결과값이 accumulator 으로 설정됩니다.
 *
 */
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


/**
 * - Expression 입력값 Null, Empty 을 체크합니다.
 * - 정해진 규칙에 맞지 않는 Expression 체크.
 * - Reduce 연산을 통해 사칙 연산을 수행합니다.
 */
object Calculator {
    private val EXPRESSION_REGEX = """(\d*) ([+\-*/]) (\d*)""".toRegex()
    private const val NOT_EMPTY_OR_NULL_MSG = "입력 값은 null 또는 빈 문자열을 사용할 수 없습니다."
    private const val NOT_MATCH_EXPRESSION = "X operator Y 규칙에 맞지 않는 포멧입니다."

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
            else -> throw IllegalArgumentException()
        }
    }
}

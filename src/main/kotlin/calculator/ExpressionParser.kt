package calculator

class ExpressionParser {

    fun parse(parseTarget: String): List<Expression> {
        try {
            val splitParseTarget: List<String> = parseTarget.split(" ")
            val expressionList: List<Expression> = listOf<Expression>().plus(
                Expression(
                    splitParseTarget[0].toLong(),
                    Operator.valueOf(splitParseTarget[1]),
                    splitParseTarget[2].toLong()
                )
            )

            for (idx: Int in 3 until splitParseTarget.size step 2) {
                val operator: Operator = Operator.valueOf(splitParseTarget[idx + 1])
                val right: Long = splitParseTarget[idx + 2].toLong()

                expressionList.plus(Expression(null, operator, right))
            }

            return expressionList
        } catch (formatException: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        } catch (notFoundException: NoSuchElementException) {
            throw IllegalArgumentException("사칙연산 기호만 입력 가능합니다.")
        }
    }
}

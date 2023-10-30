package calculator

class ExpressionParser {

    fun parse(parseTarget: String): List<Expression> {
        try {
            val splitParseTarget: List<String> = parseTarget.split(" ")
            val expressionList: MutableList<Expression> = mutableListOf<Expression>(
                Expression(
                    splitParseTarget[0].toLong(),
                    findOperator(splitParseTarget[1]),
                    splitParseTarget[2].toLong()
                )
            )

            for (idx: Int in 3 until splitParseTarget.size step 2) {
                val operator: Operator = findOperator(splitParseTarget[idx])
                val right: Long = splitParseTarget[idx + 1].toLong()

                expressionList.add(Expression(null, operator, right))
            }

            return expressionList
        } catch (formatException: NumberFormatException) {
            throw IllegalArgumentException("숫자 형식이 아닙니다.")
        }
    }

    private fun findOperator(operator: String): Operator {
        return Operator.values().find { it.operator == operator }
            ?: throw IllegalArgumentException("사칙연산 기호만 입력 가능합니다.")
    }
}

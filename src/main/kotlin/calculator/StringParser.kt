package calculator

object StringParser {
    fun parse(parseTarget: String): List<Map<String, Any?>> {
        try {
            val splitParseTarget: List<String> = parseTarget.split(" ")
            val expressionList: MutableList<Map<String, Any?>> = mutableListOf<Map<String, Any?>>(
                mapOf(
                    "left" to splitParseTarget[0],
                    "operator" to findOperator(splitParseTarget[1]),
                    "right" to splitParseTarget[2]
                )
            )

            for (idx: Int in 3 until splitParseTarget.size step 2) {
                val operator: Any = findOperator(splitParseTarget[idx])
                val right: String = splitParseTarget[idx + 1]

                expressionList.add(
                    mapOf(
                        "left" to null, "operator" to operator, "right" to right
                    )
                )
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

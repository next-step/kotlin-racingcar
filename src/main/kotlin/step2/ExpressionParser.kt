package step2

/**
 * ### 토큰화된 연산식 문자를 계산에 사용될 구체적인 타입인 '연산자'와 '피연산자' 타입으로 가공하는 파서 입니다.
 */
class ExpressionParser {
    fun parse(expressionTokens: List<String>): List<ExpressionItem> {
        return expressionTokens.map {
            when (it.toDoubleOrNull()) {
                null -> Operator.of(it)
                else -> Operand(it)
            }
        }.toList()
    }
}

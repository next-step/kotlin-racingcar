package step2.expression

/**
 * ### 연산식에서 추출한 토큰 입니다.
 */
data class ExpressionToken(private val token: String) {
    fun toExpressionItem(): ExpressionItem {
        return when (token.toDoubleOrNull()) {
            null -> Operator.of(token)
            else -> Operand(token)
        }
    }
}

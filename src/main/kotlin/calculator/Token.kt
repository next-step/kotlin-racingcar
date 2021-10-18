package calculator

data class Token(
    val type: Type,
    val literal: String,
) {

    enum class Type {
        NUMBER,
        OPERATOR,
        ;
    }
}

private const val SPACE = " "

fun getTokens(expression: String): List<Token> {
    val literals = expression.trim().split(SPACE)
    return literals.map(::toToken)
}

private fun toToken(literal: String): Token {
    if (OperatorFactory.findBinaryFor(literal) != null) {
        return Token(Token.Type.OPERATOR, literal)
    }
    if (literal.toDoubleOrNull() != null) {
        return Token(Token.Type.NUMBER, literal)
    }
    throw IllegalArgumentException("${literal}은 지원하지 않는 (피)연산자입니다.")
}

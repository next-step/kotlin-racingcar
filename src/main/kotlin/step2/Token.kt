package step2

data class Token private constructor(
    val type: TokenType,
    val value: String,
) {

    companion object {
        fun of(value: String): Token {
            val tokenType = TokenType.getByValue(value = value)
            return Token(
                type = tokenType,
                value = value,
            )
        }
    }
}

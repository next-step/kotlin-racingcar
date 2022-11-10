package step2

object ExpressionTokenizer {
    private const val SPACE = " "

    fun tokenize(expression: String): List<Token> =
        expression
            .split(SPACE)
            .filter { !it.isNullOrBlank() }
            .map { Token.of(value = it) }
}

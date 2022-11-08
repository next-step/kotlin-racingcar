package step2

object ExpressionTokenizer {
    private const val SPACE = " "

    fun tokenize(expression: String): List<Token> {
        return expression
            .split(SPACE)
            .filter { !it.isNullOrBlank() }
            .map { Token(it) }
    }
}

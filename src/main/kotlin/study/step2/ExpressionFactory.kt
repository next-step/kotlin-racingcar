package study.step2

class ExpressionFactory(
    private val tokenizer: Tokenizer
) {
    fun create(expressionStr: String?): Expression {
        require(!expressionStr.isNullOrBlank())
        val rawTokens = tokenizer.tokenize(expressionStr)
        return Expression(rawTokens)
    }
}

package study.step2

class Tokenizer(
    private val tokenListValidator: TokenListValidator
) {
    fun tokenize(expressionStr: String): List<String> {
        val rawTokens = expressionStr.split(" ")
        tokenListValidator.validate(rawTokens)
        return rawTokens
    }
}

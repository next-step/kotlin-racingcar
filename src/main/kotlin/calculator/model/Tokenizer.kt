package calculator.model

object Tokenizer {
    fun toTokens(input: String): List<String> {
        return removeWhitespace(input)
            .split("(?=[+\\-*/])|(?<=[+\\-*/])".toRegex())
    }

    private fun removeWhitespace(string: String): String {
        return string.replace("\\s".toRegex(), "")
    }
}

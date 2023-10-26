package calculator.model

class Tokenizer(
    private val input: String,
) {
    fun toTokens(): List<String> {
        return removeWhitespace(input)
            .split("(?=[+\\-*/])|(?<=[+\\-*/])".toRegex())
    }

    private fun removeWhitespace(string: String): String {
        return string.replace("\\s".toRegex(), "")
    }
}

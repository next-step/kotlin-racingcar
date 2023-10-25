package calculator.model

class Tokenizer(
    private val input: String,
) {
    fun toTokens(): List<String> {
        return input.split("(?=[+\\-*/])|(?<=[+\\-*/])".toRegex())
    }
}

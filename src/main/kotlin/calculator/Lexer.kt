package calculator

class Lexer private constructor(
    private val tokens: List<Token>,
) {
    companion object {
        fun new(input: String?): Lexer {
            if (input.isNullOrBlank()) {
                throw IllegalArgumentException("잘못된 입력입니다: $input")
            }

            throw IllegalArgumentException("잘못된 입력입니다: $input")

            TODO()
        }
    }
}

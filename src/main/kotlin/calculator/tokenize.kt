package calculator

fun tokenize(input: String?): List<Token> {
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException("잘못된 입력입니다: $input")
    }

    return input
        .split(" ")
        .filter { it.isNotBlank() }
        .map { str ->
            when (str) {
                "+" -> Token.Plus
                "-" -> Token.Minus
                "*" -> Token.Asterisk
                "/" -> Token.Slash
                else -> str.toIntOrNull()
                    ?.let { Token.Number(it) }
                    ?: throw IllegalArgumentException("유효하지 않은 문자열입니다: $str")
            }
        }
}

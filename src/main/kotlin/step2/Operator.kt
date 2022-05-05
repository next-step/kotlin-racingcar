package step2

enum class Operator(
    val char: String
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/"),
    ;

    companion object {
        fun of(char: String): Operator = Operator.values().find { it.char == char }
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_OPERATOR)
    }
}

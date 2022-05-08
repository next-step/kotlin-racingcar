package step2

enum class Operator(
    val char: String,
    val calculate: (Double, Double) -> Double
) {
    PLUS("+", { acc, operator -> acc + operator }),
    MINUS("-", { acc, operator -> acc - operator }),
    MULTIPLY("*", { acc, operator -> acc * operator }),
    DIVISION("/", { acc, operator -> acc / operator }),
    ;

    companion object {
        fun of(char: String): Operator = values().find { it.char == char }
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_OPERATOR)
    }
}

package step2

enum class Operator(
    val char: String,
    val calculate: (Double, Double) -> Double
) {
    PLUS("+", { acc, operand -> acc + operand }),
    MINUS("-", { acc, operand -> acc - operand }),
    MULTIPLY("*", { acc, operand -> acc * operand }),
    DIVISION("/", { acc, operand ->
        require(operand != 0.0) { ErrorMessage.DIVIDE_BY_ZERO }
        acc / operand
    }),
    ;

    companion object {
        fun of(char: String): Operator = values().find { it.char == char }
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_OPERATOR)
    }
}

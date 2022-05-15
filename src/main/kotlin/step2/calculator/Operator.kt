package step2.calculator

enum class Operator(private val symbol: String, val calculate: (Long, Long) -> Long) {
    PLUS("+", { a, b -> Math.plus(a, b) }),
    MINUS("-", { a, b -> Math.minus(a, b) }),
    MULTIPLE("*", { a, b -> Math.multiple(a, b) }),
    DIVIDE("/", { a, b -> Math.divide(a, b) });

    companion object {
        fun find(symbol: String): Operator =
            values().find { it.symbol == symbol } ?: throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
    }
}

package step2.calculator

enum class ArithmeticParameter(private val symbol: String, val calculate: (Long, Long) -> Long) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLE("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun find(symbol: String): ArithmeticParameter =
            values().find { it.symbol == symbol } ?: throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
    }
}

package calculator

enum class Operator(
    private val symbol: String,
    private val execute: (Int, Int) -> Int,
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    fun operate(a: Int, b: Int): Int = execute(a, b)

    companion object {
        fun of(symbol: String): Operator {
            return values().firstOrNull { symbol == it.symbol }
                ?: throw IllegalArgumentException("존재하지 않는 연산 기호입니다. symbol = $symbol")
        }
    }
}

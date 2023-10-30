package calculator

enum class Operator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    companion object {
        fun of(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("사칙연산은 '+', '-', '*', '/' 만 사용 가능합니다.")
        }
    }
}

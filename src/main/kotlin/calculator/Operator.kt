package calculator

enum class Operator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    TIMES("*", { x, y -> x * y }),
    DIVISION("/", { x, y -> x / y });

    companion object {
        fun from(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("연산자를 잘못 입력하셨습니다.")
        }
    }
}

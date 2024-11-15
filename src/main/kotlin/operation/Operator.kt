package operation

enum class Operator(val symbol: String, val operation: (Int, Int) -> Int) {
    SUM("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        if (b == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        a / b
    }),
    ;

    companion object {
        fun from(symbol: String): Operator {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}

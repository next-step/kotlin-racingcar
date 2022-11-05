package calculator

enum class Operator(val expression: String, val calculate: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    DIVIDE("/", { x, y ->
        require(y != 0) { "0으로 나눌 수 없습니다.3" }
        x / y
    }),
    MULTIPLY("*", { x, y -> x * y });

    companion object {
        fun valueOf(operator: String): Operator? {
            return values().firstOrNull { it.expression.equals(operator) }
        }
    }
}

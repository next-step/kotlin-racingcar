package calculator.domain

enum class Operator(val symbol: String, val apply: (Double, Double) -> Double) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    TIMES("*", { left, right -> left * right }),
    DIVIDE("/", { left, right ->
        require(right != 0.0) { "0으로 나눌 수 없습니다." }
        left / right
    });

    companion object {
        fun isOperator(symbol: String) = values().any { it.symbol == symbol }

        fun of(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw UnsupportedOperationException("잘못된 연산자 입니다.")
        }
    }
}

package calculator

enum class Operator (val symbol: String, val operator: (left: Int, right: Int) -> Int) {

    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLE("*", { left, right -> left * right }),
    DIVISION("/", { left, right -> left / right });

    companion object {
        fun getOperator(symbol: String): Operator {
            return values()
                .find { it.symbol == symbol }
                ?: throw IllegalArgumentException("사칙연산이 아닙니다.")
        }
    }
}
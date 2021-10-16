package calculator.domain.vo

enum class Operator(
    private val symbol: String,
    val calculate: (Double, Double) -> Double,
) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    TIMES("*", { left, right -> left * right }),
    DIVIDE("/", { left, right ->
        require(right != 0.0) { "0으로 나눌 수 없습니다." }
        left / right
    });

    companion object {
        fun String.isOperator() = values().any { it.symbol == this }
        fun symbolOf(symbol: String): Operator {
            return values().find { it.symbol == symbol }.let {
                require(it != null) { "잘못된 연산자입니다." }
                it
            }
        }
    }
}

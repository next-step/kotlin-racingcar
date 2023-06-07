package next.step.calculator.domain

enum class Operator(
    private val symbol: String,
    val evaluate: (a: InputNumber, b: InputNumber) -> InputNumber
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun from(symbol: String): Operator {
            return requireNotNull(values().firstOrNull { it.symbol == symbol }) { "잘못된 형식의 연산자입니다." }
        }
    }
}

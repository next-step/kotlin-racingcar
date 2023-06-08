package calculator

private const val ZERO_EXCEPTION = "0으로는 나눌 수 없습니다."
private const val OPERATOR_EXCEPTION = "잘못된 연산자입니다."

enum class Operator(
    val operate: (Int, Int) -> Int,
) {
    PLUS({ a, b -> a + b }),
    MINUS({ a, b -> a - b }),
    MUL({ a, b -> a * b }),
    DIV({ a, b ->
        require(a != 0 && b != 0) { ZERO_EXCEPTION }
        a / b
    });

    companion object {
        fun from(operator: String): Operator {
            return when (operator) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MUL
                "/" -> DIV
                else -> throw IllegalArgumentException(OPERATOR_EXCEPTION)
            }
        }
    }
}

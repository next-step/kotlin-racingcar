package calculator

enum class Operator(
    private val symbol: String,
    private val function: (a: Int, b: Int) -> Int
) {

    ADDITION("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b }),
    ;

    fun operate(a: Int, b: Int): Int {
        return function.invoke(a, b)
    }

    companion object {
        fun of(symbol: String): Operator =
            values().firstOrNull { it.symbol == symbol } ?: throw IllegalArgumentException("$MESSAGE_WRONG_OPERATOR ($symbol)")
        const val MESSAGE_WRONG_OPERATOR = "지원하지 않는 연산자 입니다."
    }
}
